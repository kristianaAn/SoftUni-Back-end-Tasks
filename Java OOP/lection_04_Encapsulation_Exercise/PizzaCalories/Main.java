package lection_04_Encapsulation_Exercise.PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exceptionIsThrown = false;
        double calories = 0;

        String[] pizzaData = scanner.nextLine().split("\\s+");
        String pizzaName = pizzaData[1];
        int numberOfToppings = Integer.parseInt(pizzaData[2]);

        String[] doughData = scanner.nextLine().split("\\s+");
        String flourType = doughData[1];
        String bakingTechnique = doughData[2];
        double weightInGrams = Double.parseDouble(doughData[3]);

        try {
            Pizza pizza = new Pizza(pizzaName, numberOfToppings);
            Dough dough = new Dough(flourType, bakingTechnique, weightInGrams);
            pizza.setDough(dough);

            String input = scanner.nextLine();
            while (!input.equals("END")) {
                String[] toppingData = input.split("\\s+");
                String toppingType = toppingData[1];
                double weightGrams = Double.parseDouble(toppingData[2]);

                try {
                    Topping topping = new Topping(toppingType, weightGrams);
                    pizza.addTopping(topping);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    exceptionIsThrown = true;
                    break;
                }

                input = scanner.nextLine();
            }

            calories = pizza.getOverallCalories();

        } catch (IllegalArgumentException e) {
            exceptionIsThrown = true;
            System.out.println(e.getMessage());
        }

        if (!exceptionIsThrown) {
            System.out.printf("%s - %.2f", pizzaName, calories);
        }
    }
}

