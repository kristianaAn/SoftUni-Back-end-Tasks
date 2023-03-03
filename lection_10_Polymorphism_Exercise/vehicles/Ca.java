package lection_10_Polymorphism_Exercise.vehicles;

import java.text.DecimalFormat;

public class Ca extends Vehicl implements Driv, Rfuel {
    public static final double AC_ADDITIONAL_FUEL_CONSUMPTION = 0.9;

    protected Ca(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + AC_ADDITIONAL_FUEL_CONSUMPTION);
    }

    @Override
    public String drive(double distance) {
        double fuelNeeded = getFuelConsumption() * distance;
        if (fuelNeeded > getFuelQuantity()) {
            return "Car needs refueling";
        }
        setFuelQuantity(getFuelQuantity() - fuelNeeded);
        DecimalFormat df = new DecimalFormat("##.##");
        return  "Car travelled " + df.format(distance) + " km";

    }

    @Override
    public void refuel(double litres) {
        setFuelQuantity(getFuelQuantity() + litres);
    }
}
