package christmasPastryShop.core;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.common.OutputMessages;
import christmasPastryShop.core.interfaces.Controller;
import christmasPastryShop.entities.booths.BaseBooth;
import christmasPastryShop.entities.booths.OpenBooth;
import christmasPastryShop.entities.booths.PrivateBooth;
import christmasPastryShop.entities.cocktails.Hibernation;
import christmasPastryShop.entities.cocktails.MulledWine;
import christmasPastryShop.entities.delicacies.BaseDelicacy;
import christmasPastryShop.entities.delicacies.Gingerbread;
import christmasPastryShop.entities.delicacies.Stolen;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.repositories.BoothRepositoryImpl;
import christmasPastryShop.repositories.CocktailRepositoryImpl;
import christmasPastryShop.repositories.DelicacyRepositoryImpl;
import christmasPastryShop.repositories.interfaces.BoothRepository;
import christmasPastryShop.repositories.interfaces.CocktailRepository;
import christmasPastryShop.repositories.interfaces.DelicacyRepository;

import java.util.Collection;

public class ControllerImpl implements Controller {
    private double totalIncome;

    private DelicacyRepository<Delicacy> delicacyRepository;
    private CocktailRepository<Cocktail> cocktailRepository;
    private BoothRepository<Booth> boothRepository;

    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository, CocktailRepository<Cocktail> cocktailRepository, BoothRepository<Booth> boothRepository) {
        this.delicacyRepository = delicacyRepository;
        this.cocktailRepository = cocktailRepository;
        this.boothRepository = boothRepository;
    }


    @Override
    public String addDelicacy(String type, String name, double price) {
        Delicacy delicacy = null;

        switch (type) {
            case "Gingerbread":
                delicacy = new Gingerbread(name, price);
                break;
            case "Stolen":
                delicacy = new Stolen(name, price);
                break;
        }

        if (delicacyRepository.getAll().contains(delicacy)) {
            String message = String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, type, name);
            throw new IllegalArgumentException(message);
        }

        delicacyRepository.add(delicacy);
        return String.format(OutputMessages.DELICACY_ADDED, name, type);
    }

    @Override
    public String addCocktail(String type, String name, int size, String brand) {
        Cocktail cocktail = null;

        switch (type) {
            case "MulledWine":
                cocktail = new MulledWine(name, size, brand);
                break;
            case "Hibernation":
                cocktail = new Hibernation(name, size, brand);
                break;
        }

        if (cocktailRepository.getAll().contains(cocktail)) {
            String message = String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, type, name);
            throw new IllegalArgumentException(message);
        }

        cocktailRepository.add(cocktail);
        return String.format(OutputMessages.COCKTAIL_ADDED, name, brand);
    }

    @Override
    public String addBooth(String type, int boothNumber, int capacity) {
        Booth booth = null;

        switch (type) {
            case "OpenBooth":
                booth = new OpenBooth(boothNumber, capacity);
                break;
            case "PrivateBooth":
                booth = new PrivateBooth(boothNumber, capacity);
                break;
        }

        if (boothRepository.getAll().contains(booth)) {
            String message = String.format(ExceptionMessages.BOOTH_EXIST, boothNumber);
            throw new IllegalArgumentException(message);
        }

        boothRepository.add(booth);
        return String.format(OutputMessages.BOOTH_ADDED, boothNumber);
    }

    @Override
    public String reserveBooth(int numberOfPeople) {
        Booth suitableBooth = boothRepository.getAll().stream()
                .filter(booth -> !booth.isReserved())
                .filter(booth -> booth.getCapacity() >= numberOfPeople)
                .findFirst().orElse(null);

        if (suitableBooth == null) {
           return String.format(OutputMessages.RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }

        suitableBooth.reserve(numberOfPeople);
        return String.format(OutputMessages.BOOTH_RESERVED, suitableBooth.getBoothNumber(), numberOfPeople);
    }

    @Override
    public String leaveBooth(int boothNumber) {
        Booth boothToBeLeft = boothRepository.getAll().stream()
                .filter(booth -> booth.getBoothNumber() == boothNumber)
                .findFirst()
                .get();

        double boothToBeLeftBill = boothToBeLeft.getBill() + boothToBeLeft.getPrice();
        boothToBeLeft.clear();
        totalIncome += boothToBeLeftBill;
        return String.format(OutputMessages.BILL, boothNumber, boothToBeLeftBill);
    }

    @Override
    public String getIncome() {
        return String.format(OutputMessages.TOTAL_INCOME, totalIncome);
    }
}
