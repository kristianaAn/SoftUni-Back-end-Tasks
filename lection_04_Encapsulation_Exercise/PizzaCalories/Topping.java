package lection_04_Encapsulation_Exercise.PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if (!toppingType.equals("Meat") && !toppingType.equals("Veggies") && !toppingType.equals("Cheese") && !toppingType.equals("Sauce")) {
            throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(toppingType + " weight should be in the range [1..50].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        if (toppingType.equals("Meat")) {
            return 2 * weight * 1.2;
        } else if (toppingType.equals("Veggies")) {
            return 2 * weight * 0.8;
        } else if (toppingType.equals("Cheese")) {
            return 2 * weight * 1.1;
        }
        return 2 * weight * 0.9;
    }
}
