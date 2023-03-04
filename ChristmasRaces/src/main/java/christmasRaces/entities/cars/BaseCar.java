package christmasRaces.entities.cars;

import christmasRaces.common.ExceptionMessages;

public abstract class BaseCar implements Car {

    public static final int MINIMUM_LENGTH_MODEL = 4;

    private String model;
    private int horsePower;
    private double cubicCentimeters;

    public BaseCar(String model, int horsePower, double cubicCentimeters) {
        setModel(model);
        setHorsePower(horsePower);
        setCubicCentimeters(cubicCentimeters);
    }

    public double calculateRacePoints (int laps) {
        return cubicCentimeters / horsePower * laps;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model == null || model.trim().isEmpty() || model.length() < MINIMUM_LENGTH_MODEL) {
            String message = String.format(ExceptionMessages.INVALID_MODEL, model, MINIMUM_LENGTH_MODEL);
            throw new IllegalArgumentException(message);
        }
        this.model = model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public double getCubicCentimeters() {
        return cubicCentimeters;
    }

    public void setCubicCentimeters(double cubicCentimeters) {
        this.cubicCentimeters = cubicCentimeters;
    }
}
