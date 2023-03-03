package lection_12_SOLID_Exercise.solid.products.Food;

public class Chocolate extends Food {

    public static final double CALORIES_PER_100_GRAMS = 575.0;

    public Chocolate(double grams) {
        super(CALORIES_PER_100_GRAMS, grams);
    }
}
