package lection_12_DefiningClasses_Exercise_SpeedRacing_03;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCost1km;
    private int distanceTravelled;

    public Car(String model, double fuelAmount, double fuelCost1km) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCost1km = fuelCost1km;
        this.distanceTravelled = 0;
    }

    public void drive(int amountOfKm) {
        fuelAmount = fuelAmount - (amountOfKm * fuelCost1km);
        distanceTravelled = distanceTravelled + amountOfKm;
    }

    public String getModel() {
        return model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getFuelCost1km() {
        return fuelCost1km;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public void setFuelCost1km(double fuelCost1km) {
        this.fuelCost1km = fuelCost1km;
    }

    public void setDistanceTravelled(int distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", model, fuelAmount, distanceTravelled);
    }
}
