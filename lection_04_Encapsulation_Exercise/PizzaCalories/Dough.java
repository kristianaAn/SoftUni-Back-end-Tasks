package lection_04_Encapsulation_Exercise.PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (!flourType.equals("White") && !flourType.equals("Wholegrain")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!bakingTechnique.equals("Crispy") && !bakingTechnique.equals("Chewy") && !bakingTechnique.equals("Homemade")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
         return weight * 2 * bakingTechniqueModifier() * flourTypeModifier();
    }

    public double bakingTechniqueModifier() {
        if (bakingTechnique.equals("Crispy")) {
            return 0.9;
        } else if (bakingTechnique.equals("Chewy")) {
            return 1.1;
        }
        return 1.0;
    }

    public double flourTypeModifier() {
        if (flourType.equals("White")) {
            return 1.5;
        }
        return 1.0;
    }
}
