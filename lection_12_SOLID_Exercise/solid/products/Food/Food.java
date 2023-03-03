package lection_12_SOLID_Exercise.solid.products.Food;

import lection_12_SOLID_Exercise.solid.Product;

public abstract class Food implements Product {
    private double calories;
    private double grams;

    public Food(double calories, double grams) {
        this.calories = calories;
        this.grams = grams;
    }

    @Override
    public double getKilograms() {
        return grams / 1000;
    }

    @Override
    public double getCalories() {
        return (calories / 100) * grams;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getGrams() {
        return grams;
    }

    public void setGrams(double grams) {
        this.grams = grams;
    }
}
