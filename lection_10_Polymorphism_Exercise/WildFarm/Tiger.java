package lection_10_Polymorphism_Exercise.WildFarm;

public class Tiger extends Felime {
    private String livingRegion;

    public Tiger(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }


    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            setFoodEaten(getFoodEaten() + food.getQuantity());
        } else {
            System.out.println(Tiger.class.getSimpleName() + "s are not eating that type of food!");
        }
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }
}
