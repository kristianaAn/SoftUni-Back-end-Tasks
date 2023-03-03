package lection_08_InterfacesAndAbstraction_Exercise.birthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<Birthable> birthableList = new ArrayList<>();

        while (!input.equals("End")) {
            String[] inputData = input.split("\\s+");
            String creatureType = inputData[0];

            if (creatureType.equals("Citizen")) {
                String name = inputData[1];
                int age = Integer.parseInt(inputData[2]);
                String id = inputData[3];
                String birthDate = inputData[4];

                Citizen citizen = new Citizen(name, age, id, birthDate);
                birthableList.add(citizen);

            } else if (creatureType.equals("Robot")) {
                String model = inputData[1];
                String id = inputData[2];

            } else if (creatureType.equals("Pet")) {
                String name = inputData[1];
                String birthDate = inputData[2];

                Pet pet = new Pet(name, birthDate);
                birthableList.add(pet);
            }

            input = scanner.nextLine();
        }

        String year = scanner.nextLine();
        boolean matchFound = false;

        for (Birthable birthable : birthableList) {
            if (birthable.getBirthDate().endsWith(year)) {
                matchFound = true;
                System.out.println(birthable.getBirthDate());
            }
        }

        if (!matchFound) {
            System.out.println("<no output>");
        }
    }
}
