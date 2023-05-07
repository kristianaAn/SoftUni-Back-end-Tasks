package christmasRaces.entities.cars;

import christmasRaces.common.ExceptionMessages;

public class MuscleCar extends BaseCar{
    public static final double CUBIC_CENTIMETERS_MUSCLE_CAR = 5000;

    public MuscleCar(String model, int horsePower) {
        super(model, horsePower, CUBIC_CENTIMETERS_MUSCLE_CAR);
    }

    @Override
    public void setHorsePower(int horsePower) {
        if (horsePower < 400 || horsePower > 600) {
            String message = String.format(ExceptionMessages.INVALID_HORSE_POWER, horsePower);
            throw new IllegalArgumentException(message);
        }
        super.setHorsePower(horsePower);
    }

    @Override
    public double calculateRacePoints(int laps) {
        return CUBIC_CENTIMETERS_MUSCLE_CAR / getHorsePower() * laps;
    }
}
