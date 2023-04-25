package catHouse.core;

import catHouse.common.ConstantMessages;
import catHouse.common.ExceptionMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {
    private ToyRepository toys;
    private Collection<House> houses;

    public ControllerImpl() {
        this.toys = new ToyRepository();
        this.houses = new ArrayList<>();
    }

    @Override
    public String addHouse(String type, String name) {
        House house;
        switch (type) {
            case "ShortHouse":
                house = new ShortHouse(name);
                break;
            case "LongHouse":
                house = new LongHouse(name);
                break;
            default:
                throw new NullPointerException(ExceptionMessages.INVALID_HOUSE_TYPE);
        }

        this.houses.add(house);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {
        Toy toy;
        switch (type) {
            case "Ball":
                toy = new Ball();
                break;
            case "Mouse":
                toy = new Mouse();
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_TOY_TYPE);
        }

        this.toys.buyToy(toy);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy toyToBuyForTheHouse = this.toys.findFirst(toyType);
        if (toyToBuyForTheHouse == null) {
            String message = String.format(ExceptionMessages.NO_TOY_FOUND, toyType);
            throw new IllegalArgumentException(message);
        }

        House houseToBuyFor = getHouseToAddTo(houseName);
        houseToBuyFor.buyToy(toyToBuyForTheHouse);
        this.toys.removeToy(toyToBuyForTheHouse);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        Cat cat;
        switch (catType) {
            case "ShorthairCat":
                cat = new ShorthairCat(catName, catBreed, price);
                break;
            case "LonghairCat":
                cat = new LonghairCat(catName, catBreed, price);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_CAT_TYPE);
        }

        House houseToAddTo = getHouseToAddTo(houseName);
        boolean checkLong = houseToAddTo.getClass().getSimpleName().startsWith("Long") && catType.startsWith("Long");
        boolean checkShort = houseToAddTo.getClass().getSimpleName().startsWith("Short") && catType.startsWith("Short");

        if (checkLong || checkShort) {
            houseToAddTo.addCat(cat);
            return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
        } else {
            return ConstantMessages.UNSUITABLE_HOUSE;
        }
    }

    private House getHouseToAddTo(String houseName) {
        return this.houses.stream().filter(house -> house.getName().equals(houseName)).findFirst().get();
    }

    @Override
    public String feedingCat(String houseName) {
         House houseToFeedCats = getHouseToAddTo(houseName);
         houseToFeedCats.feeding();
         int catsToBeFed = houseToFeedCats.getCats().size();
         return String.format(ConstantMessages.FEEDING_CAT, catsToBeFed);
    }

    @Override
    public String sumOfAll(String houseName) {
        House house = getHouseToAddTo(houseName);
        double sumForCats = house.getCats().stream().mapToDouble(Cat::getPrice).sum();
        double sumForToys = house.getToys().stream().mapToDouble(Toy::getPrice).sum();
        double sumAll = sumForCats + sumForToys;

        return String.format(ConstantMessages.VALUE_HOUSE, houseName, sumAll);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (House house : this.houses) {
            sb.append(house.getStatistics())
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
