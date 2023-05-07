package lection_12_SOLID_Exercise.solid.products.Drinks;

import lection_12_SOLID_Exercise.solid.Product;

public abstract class Drink implements Product {
    private double calories;
    private double density;
    private double milliliters;

    public Drink(double calories, double density, double milliliters) {
        this.calories = calories;
        this.density = density;
        this.milliliters = milliliters;
    }

    public double getDrinkInLiters () {
        return milliliters / 1000;
    }

    @Override
    public double getKilograms() {
        return getDrinkInLiters() * density;
    }

    @Override
    public double getCalories() {
        double grams = milliliters * density;
        return (calories / 100) * grams;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public double getMilliliters() {
        return milliliters;
    }

    public void setMilliliters(double milliliters) {
        this.milliliters = milliliters;
    }
}
