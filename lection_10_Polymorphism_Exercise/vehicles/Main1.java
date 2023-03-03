package lection_10_Polymorphism_Exercise.vehicles;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carInputData = scanner.nextLine().split("\\s+");
        double fuelQuantity = Double.parseDouble(carInputData[1]);
        double fuelConsumption = Double.parseDouble(carInputData[2]);
        Ca ca = new Ca(fuelQuantity, fuelConsumption);

        String[] truckInputData = scanner.nextLine().split("\\s+");
        double truckFuel = Double.parseDouble(truckInputData[1]);
        double truckConsumption = Double.parseDouble(truckInputData[2]);
        Truk truk = new Truk(truckFuel, truckConsumption);

        int commandsCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < commandsCount; i++) {
            String[] commandData = scanner.nextLine().split("\\s+");
            String commandType = commandData[0];
            String vehicle = commandData[1];
            double amount = Double.parseDouble(commandData[2]);

            if (commandType.equals("Drive")) {
                if (vehicle.equals("Car")) {
                    System.out.println(ca.drive(amount));
                } else {
                    System.out.println(truk.drive(amount));
                }
            } else {
                if (vehicle.equals("Car")) {
                    ca.refuel(amount);
                } else {
                    truk.refuel(amount);
                }
            }
        }

        System.out.println(ca.toString());
        System.out.println(truk.toString());
    }
}
