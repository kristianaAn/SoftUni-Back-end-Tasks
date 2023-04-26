package christmasPastryShop.entities.booths;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseBooth implements Booth {
    private Collection<Delicacy> delicacyOrders;
    private Collection<Cocktail> cocktailOrders;
    private int boothNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    public BaseBooth(int boothNumber, int capacity, double pricePerPerson) {
        this.delicacyOrders = new ArrayList<>();
        this.cocktailOrders = new ArrayList<>();
        this.setBoothNumber(boothNumber);
        this.setCapacity(capacity);
        this.setPricePerPerson(pricePerPerson);
        this.isReserved = false;
    }

    public Collection<Delicacy> getDelicacyOrders() {
        return delicacyOrders;
    }

    public void setDelicacyOrders(Collection<Delicacy> delicacyOrders) {
        this.delicacyOrders = delicacyOrders;
    }

    public Collection<Cocktail> getCocktailOrders() {
        return cocktailOrders;
    }

    public void setCocktailOrders(Collection<Cocktail> cocktailOrders) {
        this.cocktailOrders = cocktailOrders;
    }

    @Override
    public int getBoothNumber() {
        return boothNumber;
    }

    public void setBoothNumber(int boothNumber) {
        this.boothNumber = boothNumber;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    public double getPricePerPerson() {
        return pricePerPerson;
    }

    public void setPricePerPerson(double pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
    }

    @Override
    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void reserve(int numberOfPeople) {
        this.isReserved = true;
        this.price = numberOfPeople * getPricePerPerson();
    }

    @Override
    public double getBill() {
        double delicaciesBill = this.delicacyOrders.stream().mapToDouble(Delicacy::getPrice).sum();
        double cocktailsBill = this.cocktailOrders.stream().mapToDouble(Cocktail::getPrice).sum();
        return delicaciesBill + cocktailsBill;
    }

    @Override
    public void clear() {
        this.delicacyOrders.clear();
        this.cocktailOrders.clear();
        setReserved(false);
        setNumberOfPeople(1);
        setPrice(0);
    }
}
