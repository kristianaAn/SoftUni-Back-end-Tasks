package final_Exam_Preparation_02;

import java.util.*;

public class NeedForSpeedIII_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Integer>> carTypeAndDetails = new LinkedHashMap<>();
        for (int i = 1; i <= n; i++) {
            String carInfo = scanner.nextLine();
            String carBrand = carInfo.split("\\|")[0];
            int mileage = Integer.parseInt(carInfo.split("\\|")[1]);
            int fuelAmount = Integer.parseInt(carInfo.split("\\|")[2]);

            carTypeAndDetails.put(carBrand, new ArrayList<>());
            carTypeAndDetails.get(carBrand).add(mileage);
            carTypeAndDetails.get(carBrand).add(fuelAmount);
        }

        String input = scanner.nextLine();

        while (!input.equals("Stop")) {
            if (input.contains("Drive")) {
                String car = input.split(" : ")[1];
                int distance = Integer.parseInt(input.split(" : ")[2]);
                int fuelNeeded = Integer.parseInt(input.split(" : ")[3]);

                int carCurrentMileage = carTypeAndDetails.get(car).get(0);
                int carAvailableFuel = carTypeAndDetails.get(car).get(1);


                if (carAvailableFuel >= fuelNeeded) {
                    carCurrentMileage += distance;
                    carAvailableFuel -= fuelNeeded;
                    System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, fuelNeeded);

                    if (carCurrentMileage < 100000) {
                        carTypeAndDetails.replace(car, new ArrayList<>());
                        carTypeAndDetails.get(car).add(carCurrentMileage);
                        carTypeAndDetails.get(car).add(carAvailableFuel);
                    } else {
                        carTypeAndDetails.remove(car);
                        System.out.printf("Time to sell the %s!%n", car);
                    }

                } else {
                    System.out.println("Not enough fuel to make that ride");
                }

            } else if (input.contains("Refuel")) {

                String car = input.split(" : ")[1];
                int fuelToRefill = Integer.parseInt(input.split(" : ")[2]);

                int currentFuel = carTypeAndDetails.get(car).get(1);
                int currentMileage = carTypeAndDetails.get(car).get(0);
                int totalFuel = currentFuel + fuelToRefill;

                int fuelAdded = 0;

                if (totalFuel > 75) {
                    fuelAdded = 75 - currentFuel;
                    totalFuel = 75;
                } else {
                    fuelAdded = fuelToRefill;
                }

                carTypeAndDetails.replace(car, new ArrayList<>());
                carTypeAndDetails.get(car).add(currentMileage);
                carTypeAndDetails.get(car).add(totalFuel);

                System.out.printf("%s refueled with %d liters%n", car, fuelAdded);

            } else if (input.contains("Revert")) {

                String car = input.split(" : ")[1];
                int kilometersToRemove = Integer.parseInt(input.split(" : ")[2]);

                int initialMileage = carTypeAndDetails.get(car).get(0);
                int carFuel = carTypeAndDetails.get(car).get(1);

                initialMileage -= kilometersToRemove;

                if (initialMileage < 10000) {
                    initialMileage = 10000;
                } else {
                    System.out.printf("%s mileage decreased by %d kilometers%n", car, kilometersToRemove);
                }

                carTypeAndDetails.replace(car, new ArrayList<>());
                carTypeAndDetails.get(car).add(initialMileage);
                carTypeAndDetails.get(car).add(carFuel);

            }

            input = scanner.nextLine();
        }

        carTypeAndDetails.entrySet().forEach(entry -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",
                entry.getKey(), entry.getValue().get(0), entry.getValue().get(1)));

    }
}
