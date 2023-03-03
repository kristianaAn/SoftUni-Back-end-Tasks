package lection_12_DefiningClasses_Exercise_SpeedRacing_03;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Car> carList = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            //"{Model} {FuelAmount} {FuelCostFor1km}"
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            double fuelAmount = Double.parseDouble(input[1]);
            double fuelCostPerKm = Double.parseDouble(input[2]);

            Car car = new Car(model, fuelAmount, fuelCostPerKm);
            carList.put(model, car);
        }

        String inputCommands = scanner.nextLine();

        while (!inputCommands.equals("End")) {
            //"Drive {CarModel} {amountOfKm}"
            String carModel = inputCommands.split("\\s+")[1];
            int amountOfKm = Integer.parseInt(inputCommands.split("\\s+")[2]);

            Car carToDrive = carList.get(carModel);
            double fuelNeeded = amountOfKm * carToDrive.getFuelCost1km();
            if (carToDrive.getFuelAmount() - fuelNeeded >= 0) {
                carToDrive.drive(amountOfKm);
            } else {
                System.out.println("Insufficient fuel for the drive");
            }

            inputCommands = scanner.nextLine();
        }

        carList.entrySet().forEach(car -> System.out.println(car.getValue().toString()));
    }
}
