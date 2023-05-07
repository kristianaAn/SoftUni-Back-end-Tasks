package lection_10_Polymorphism_Exercise.WildFarm;

public class Zebra extends Mammal {

    public Zebra(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Vegetable) {
            setFoodEaten(getFoodEaten() + food.getQuantity());
        } else {
            System.out.println(Zebra.class.getSimpleName() + "s are not eating that type of food!");
        }
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }
}
