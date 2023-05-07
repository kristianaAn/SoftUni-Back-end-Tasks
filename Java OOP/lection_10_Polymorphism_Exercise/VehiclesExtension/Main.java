package lection_10_Polymorphism_Exercise.VehiclesExtension;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Car car = getCar(scanner);
        Truck truck = getTruck(scanner);
        Bus bus = getBus(scanner);

        int commandsCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < commandsCount; i++) {
            String[] commandData = scanner.nextLine().split("\\s+");
            String commandType = commandData[0];
            String vehicle = commandData[1];
            double amount = Double.parseDouble(commandData[2]);

            if (commandType.equals("Drive")) {
                vehicleDrive(car, truck, bus, vehicle, amount);
            } else if (commandType.equals("DriveEmpty")){
                System.out.println(bus.drive(amount));
            } else {
                vehicleRefuel(car, truck, bus, vehicle, amount);
            }
        }

        System.out.println(car.toString());
        System.out.println(truck.toString());
        System.out.println(bus.toString());
    }

    private static Bus getBus(Scanner scanner) {
        String[] busInputData = scanner.nextLine().split("\\s+");
        double busFuel = Double.parseDouble(busInputData[1]);
        double busConsumption = Double.parseDouble(busInputData[2]);
        int tankCapacity = Integer.parseInt(busInputData[3]);
        Bus bus = new Bus(busFuel, busConsumption, tankCapacity);
        return bus;
    }

    private static Truck getTruck(Scanner scanner) {
        String[] truckInputData = scanner.nextLine().split("\\s+");
        double truckFuel = Double.parseDouble(truckInputData[1]);
        double truckConsumption = Double.parseDouble(truckInputData[2]);
        int tankCapacity = Integer.parseInt(truckInputData[3]);
        Truck truck = new Truck(truckFuel, truckConsumption, tankCapacity);
        return truck;
    }

    private static Car getCar(Scanner scanner) {
        String[] carInputData = scanner.nextLine().split("\\s+");
        double fuelQuantity = Double.parseDouble(carInputData[1]);
        double fuelConsumption = Double.parseDouble(carInputData[2]);
        int tankCapacity = Integer.parseInt(carInputData[3]);
        Car car = new Car(fuelQuantity, fuelConsumption, tankCapacity);
        return car;
    }

    private static void vehicleDrive(Car car, Truck truck, Bus bus, String vehicle, double amount) {
        if (vehicle.equals("Car")) {
            System.out.println(car.drive(amount));
        } else if (vehicle.equals("Truck")){
            System.out.println(truck.drive(amount));
        } else {
            System.out.println(bus.driveFull(amount));
        }
    }

    private static void vehicleRefuel(Car car, Truck truck, Bus bus, String vehicle, double amount) {
        if (vehicle.equals("Car")) {
            car.refuel(amount);
        } else if (vehicle.equals("Truck")){
            truck.refuel(amount);
        } else {
            bus.refuel(amount);
        }
    }
}
