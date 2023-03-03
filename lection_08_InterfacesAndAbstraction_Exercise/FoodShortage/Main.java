package lection_08_InterfacesAndAbstraction_Exercise.FoodShortage;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Buyer> namesList = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] inputData = scanner.nextLine().split("\\s+");

            if (inputData.length == 4) {
                String name = inputData[0];
                int age = Integer.parseInt(inputData[1]);
                String id = inputData[2];
                String birthDate = inputData[3];

                Citizen citizen = new Citizen(name, age, id, birthDate);
                namesList.put(name, citizen);

            } else if (inputData.length == 3) {
                String name = inputData[0];
                int age = Integer.parseInt(inputData[1]);
                String group = inputData[2];

                Rebel rebel = new Rebel(name, age, group);
                namesList.put(name, rebel);
            }
        }

        String nameInput = scanner.nextLine();
        int totalFood = 0;

        while (!nameInput.equals("End")) {
            if (namesList.containsKey(nameInput)) {
                namesList.get(nameInput).buyFood();
            }

            nameInput = scanner.nextLine();
        }

        for (var buyerEntry : namesList.entrySet()) {
            totalFood += buyerEntry.getValue().getFood();
        }
        System.out.println(totalFood);
    }
}
