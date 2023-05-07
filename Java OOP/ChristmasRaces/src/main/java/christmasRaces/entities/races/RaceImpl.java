package christmasRaces.entities.races;

import christmasRaces.common.ExceptionMessages;
import christmasRaces.entities.drivers.Driver;

import java.util.ArrayList;
import java.util.Collection;

public class RaceImpl implements Race {
    public static final int MINIMUM_NAME_LENGTH = 5;
    public static final int MINIMUM_LAPS = 1;

    private String name;
    private int laps;
    private Collection<Driver> drivers;

    public RaceImpl(String name, int laps) {
        setName(name);
        setLaps(laps);
        drivers = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() < MINIMUM_NAME_LENGTH) {
            String message = String.format(ExceptionMessages.INVALID_NAME, name, MINIMUM_NAME_LENGTH);
            throw new IllegalArgumentException(message);
        }
        this.name = name;
    }

    public void setLaps(int laps) {
        if (laps < MINIMUM_LAPS) {
            String message = String.format(ExceptionMessages.INVALID_NUMBER_OF_LAPS, MINIMUM_LAPS);
            throw new IllegalArgumentException(message);
        }
        this.laps = laps;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getLaps() {
        return this.laps;
    }

    @Override
    public Collection<Driver> getDrivers() {
        return this.drivers;
    }

    @Override
    public void addDriver(Driver driver) {
        if (driver == null) {
            throw new IllegalArgumentException(ExceptionMessages.DRIVER_INVALID);
        } else if (!driver.getCanParticipate()) {
            String message = String.format(ExceptionMessages.DRIVER_NOT_PARTICIPATE, driver.getName());
            throw new IllegalArgumentException(message);
        } else if (drivers.contains(driver)) {
            String message = String.format(ExceptionMessages.DRIVER_ALREADY_ADDED, driver.getName(), this.name);
            throw new IllegalArgumentException(message);
        }

        drivers.add(driver);
    }
}
