package vehicleCatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<VehicleCatalogue> vehicleCatalogueList = new ArrayList<>();
        while (!input.equals("End")) {
            //{typeOfVehicle} {model} {color} {horsepower}
            String typeOfVehicle = input.split(" ")[0];
            String model = input.split(" ")[1];
            String color = input.split(" ")[2];
            int horsepower = Integer.parseInt(input.split(" ")[3]);

            VehicleCatalogue vehicleCatalogue = new VehicleCatalogue(typeOfVehicle, model, color, horsepower);
            vehicleCatalogueList.add(vehicleCatalogue);

            input = scanner.nextLine();
        }


        String newInput = scanner.nextLine();

        while (!newInput.equals("Close the Catalogue")) {
            for (VehicleCatalogue vehicle : vehicleCatalogueList) {
                if (vehicle.getModel().equals(newInput)) {
                    System.out.println(vehicle.toString());
                }
            }
            newInput = scanner.nextLine();
        }
        //Cars have average horsepower of: 413.33.
        //Trucks have average horsepower of: 250.00.

        System.out.printf("Cars have average horsepower of: %.2f.%n", carsAveragePower(vehicleCatalogueList));
        System.out.printf("Trucks have average horsepower of: %.2f.", trucksAveragePower(vehicleCatalogueList));
    }

    public static double carsAveragePower(List<VehicleCatalogue> vehicles) {
        int carsCount = 0;
        double totalPowerCars = 0;

        for (VehicleCatalogue currentVehicle : vehicles) {
            if (currentVehicle.getTypeOfVehicle().equals("car")) {
                carsCount++;
                totalPowerCars += currentVehicle.getHorsepower();
            }
        }
        if (carsCount > 0) {
            return totalPowerCars / carsCount;
        } else {
            return 0.00;
        }
    }

    public static double trucksAveragePower(List<VehicleCatalogue> vehicles) {
        int trucksCount = 0;
        double totalPowerTrucks = 0;

        for (VehicleCatalogue currentVehicle : vehicles) {
            if (currentVehicle.getTypeOfVehicle().equals("truck")) {
                trucksCount++;
                totalPowerTrucks += currentVehicle.getHorsepower();
            }
        }
        if (trucksCount > 0) {
            return totalPowerTrucks / trucksCount;
        } else {
            return 0.00;
        }
    }
}
