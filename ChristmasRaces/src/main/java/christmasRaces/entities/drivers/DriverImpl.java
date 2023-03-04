package christmasRaces.entities.drivers;

import christmasRaces.common.ExceptionMessages;
import christmasRaces.entities.cars.Car;

public class DriverImpl implements Driver{
    public static final int MINIMUM_NAME_LENGTH = 5;

    private String name;
    private Car car;
    private int numberOfWins;
    private boolean canParticipate;

    public DriverImpl(String name) {
        setName(name);
        this.canParticipate = false;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() < MINIMUM_NAME_LENGTH) {
            String message = String.format(ExceptionMessages.INVALID_NAME, name, MINIMUM_NAME_LENGTH);
            throw new IllegalArgumentException(message);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Car getCar() {
        return this.car;
    }

    @Override
    public int getNumberOfWins() {
        return this.numberOfWins;
    }

    @Override
    public void addCar(Car car) {
        if (car == null) {
            throw new IllegalArgumentException(ExceptionMessages.CAR_INVALID);
        }
        this.car = car;
        this.canParticipate = true;
    }

    @Override
    public void winRace() {
        numberOfWins++;
    }

    @Override
    public boolean getCanParticipate() {
        return car != null;
    }
}
