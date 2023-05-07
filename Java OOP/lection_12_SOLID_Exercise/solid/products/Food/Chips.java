package lection_12_SOLID_Exercise.solid.products.Food;

public class Chips extends Food {

    public static final double CALORIES_PER_100_GRAMS = 529;

    public Chips(double grams) {
        super(CALORIES_PER_100_GRAMS, grams);
    }
}
