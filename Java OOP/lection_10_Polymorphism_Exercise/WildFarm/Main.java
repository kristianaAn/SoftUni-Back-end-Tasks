package lection_10_Polymorphism_Exercise.WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowsCount = 0;
        String input = scanner.nextLine();

        List<Animal> animals = new ArrayList<>();
        List<Food> foods = new ArrayList<>();

        while (!input.equals("End")) {
            String[] inputData = input.split("\\s+");
            if (rowsCount % 2 == 0) { //even row
                String animalType = inputData[0];
                String animalName = inputData[1];
                double animalWeight = Double.parseDouble(inputData[2]);
                String animalLivingRegion = inputData[3];

                if ("Cat".equals(animalType)) {
                    String catBreed = inputData[4];
                    Animal cat = new Cat(animalName, animalType, animalWeight, animalLivingRegion, catBreed);
                    animals.add(cat);
                } else if ("Tiger".equals(animalType)) {
                    Animal tiger = new Tiger(animalName, animalType, animalWeight, animalLivingRegion);
                    animals.add(tiger);
                } else if ("Zebra".equals(animalType)) {
                    Animal zebra = new Zebra(animalName, animalType, animalWeight, animalLivingRegion);
                    animals.add(zebra);
                } else if ("Mouse".equals(animalType)) {
                    Animal mouse = new Mouse(animalName, animalType, animalWeight, animalLivingRegion);
                    animals.add(mouse);

                }
            } else { // odd row
                String foodType = inputData[0];
                int quantity = Integer.parseInt(inputData[1]);

                switch (foodType) {
                    case "Vegetable":
                        Food vegetable = new Vegetable(quantity);
                        foods.add(vegetable);
                        break;
                    case "Meat":
                        Food meat = new Meat(quantity);
                        foods.add(meat);
                        break;
                }
            }
            rowsCount++;
            input = scanner.nextLine();
        }

        for (int i = 0; i < animals.size(); i++) {
            Animal currentAnimal = animals.get(i);
            Food foodToEat = foods.get(i);
            currentAnimal.makeSound();
            currentAnimal.eat(foodToEat);
        }

        for (int i = 0; i < animals.size(); i++) {
            System.out.println(animals.get(i));
        }
    }
}
