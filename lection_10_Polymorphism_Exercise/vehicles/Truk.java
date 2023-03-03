package lection_10_Polymorphism_Exercise.vehicles;

import java.text.DecimalFormat;

public class Truk extends Vehicl implements Driv, Rfuel {
    public static final double AC_ADDITIONAL_FUEL_CONSUMPTION = 1.6;
    public static final double FUEL_AFTER_DRIVER_DEDUCTION = 0.95;

    protected Truk(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + AC_ADDITIONAL_FUEL_CONSUMPTION);
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
        setFuelQuantity(getFuelQuantity() + litres * FUEL_AFTER_DRIVER_DEDUCTION);
    }

}
