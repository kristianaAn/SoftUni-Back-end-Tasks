package lection_10_Polymorphism_Exercise.VehiclesExtension;

import java.text.DecimalFormat;

public class Truck extends Vehicle implements Drive, Refuel{
    public static final double AC_ADDITIONAL_FUEL_CONSUMPTION = 1.6;
    public static final double FUEL_AFTER_DRIVER_DEDUCTION = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption, int tankCapacity) {
        super(fuelQuantity, fuelConsumption + AC_ADDITIONAL_FUEL_CONSUMPTION, tankCapacity);
    }

    @Override
    public String drive(double distance) {
        double fuelNeeded = getFuelConsumption() * distance;
        if (fuelNeeded > getFuelQuantity()) {
            return "Truck needs refueling";
        }
        setFuelQuantity(getFuelQuantity() - fuelNeeded);
        DecimalFormat df = new DecimalFormat("##.##");
        return "Truck travelled " + df.format(distance) + " km";

    }

    @Override
    public void refuel(double litres) {
        double updatedFuel = getFuelQuantity() + litres;
        if (litres <= 0) {
            System.out.println("Fuel must be a positive number");
        } else if (updatedFuel > getTankCapacity()) {
            System.out.println("Cannot fit fuel in tank");
        } else {
            setFuelQuantity(getFuelQuantity() + litres * FUEL_AFTER_DRIVER_DEDUCTION);
        }
    }
}
