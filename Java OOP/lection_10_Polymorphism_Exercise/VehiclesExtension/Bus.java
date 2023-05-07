package lection_10_Polymorphism_Exercise.VehiclesExtension;

import java.text.DecimalFormat;

public class Bus extends Vehicle implements Drive, Refuel, DriveFull {
    private static final double AC_ADDITIONAL_FUEL_CONSUMPTION = 1.4;

    public Bus(double fuelQuantity, double fuelConsumption, int tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public String drive(double distance) {
        double fuelNeeded = getFuelConsumption() * distance;
        if (fuelNeeded > getFuelQuantity()) {
            return "Bus needs refueling";
        }
        setFuelQuantity(getFuelQuantity() - fuelNeeded);
        DecimalFormat df = new DecimalFormat("##.##");
        return  "Bus travelled " + df.format(distance) + " km";
    }

    @Override
    public void refuel(double litres) {
        double updatedFuel = getFuelQuantity() + litres;
        if (litres <= 0) {
            System.out.println("Fuel must be a positive number");
        } else if (updatedFuel > getTankCapacity()) {
            System.out.println("Cannot fit fuel in tank");
        } else {
            setFuelQuantity(getFuelQuantity() + litres);
        }
    }

    @Override
    public String driveFull(double distance) {
        double fuelNeeded = (getFuelConsumption() + AC_ADDITIONAL_FUEL_CONSUMPTION) * distance;
        if (fuelNeeded > getFuelQuantity()) {
            return "Bus needs refueling";
        }
        setFuelQuantity(getFuelQuantity() - fuelNeeded);
        DecimalFormat df = new DecimalFormat("##.##");
        return  "Bus travelled " + df.format(distance) + " km";
    }
}
