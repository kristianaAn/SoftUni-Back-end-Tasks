package christmasRaces.entities.cars;

import christmasRaces.common.ExceptionMessages;

public class SportsCar extends BaseCar{
    public static final double CUBIC_CENTIMETERS_SPORTS_CAR = 3000;

    public SportsCar(String model, int horsePower) {
        super(model, horsePower, CUBIC_CENTIMETERS_SPORTS_CAR);
    }

    @Override
    public void setHorsePower(int horsePower) {
        if (horsePower < 250 || horsePower > 450) {
            String message = String.format(ExceptionMessages.INVALID_HORSE_POWER, horsePower);
            throw new IllegalArgumentException(message);
        }
        super.setHorsePower(horsePower);
    }

    @Override
    public double calculateRacePoints(int laps) {
        return CUBIC_CENTIMETERS_SPORTS_CAR / getHorsePower() * laps;
    }
}
