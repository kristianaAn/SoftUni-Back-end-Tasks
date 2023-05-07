package christmasRaces.core;

import christmasRaces.common.ExceptionMessages;
import christmasRaces.common.OutputMessages;
import christmasRaces.core.interfaces.Controller;
import christmasRaces.entities.cars.BaseCar;
import christmasRaces.entities.cars.Car;
import christmasRaces.entities.cars.MuscleCar;
import christmasRaces.entities.cars.SportsCar;
import christmasRaces.entities.drivers.Driver;
import christmasRaces.entities.drivers.DriverImpl;
import christmasRaces.entities.races.Race;
import christmasRaces.entities.races.RaceImpl;
import christmasRaces.repositories.CarRepository;
import christmasRaces.repositories.DriverRepository;
import christmasRaces.repositories.RaceRepository;
import christmasRaces.repositories.interfaces.Repository;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    public static final int MINIMUM_DRIVERS_REQUIRED = 3;

    private Repository<Driver> driverRepository;
    private Repository<Car> carRepository;
    private Repository<Race> raceRepository;

    public ControllerImpl(Repository<Driver> driverRepository, Repository<Car> carRepository, Repository<Race> raceRepository) {
        this.driverRepository = driverRepository;
        this.carRepository = carRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createDriver(String driverName) {
        Driver driver = new DriverImpl(driverName);
        if (driverRepository.getByName(driverName) != null) {
            String message = String.format(ExceptionMessages.DRIVER_EXISTS, driverName);
            throw new IllegalArgumentException(message);
        }
        driverRepository.add(driver);
        String message = String.format(OutputMessages.DRIVER_CREATED, driverName);
        return message;
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        Car car = null;
        switch (type) {
            case "Muscle":
                car = new MuscleCar(model, horsePower);
                break;
            case "Sports":
                car = new SportsCar(model, horsePower);
                break;
        }

        if (carRepository.getAll().contains(car)) {
            String message = String.format(ExceptionMessages.CAR_EXISTS, model);
            throw new IllegalArgumentException(message);
        }
        carRepository.add(car);
        return String.format(OutputMessages.CAR_CREATED, type + "Car", model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        Driver driver = checkDriveExists(driverName);

        Car car = carRepository.getByName(carModel);
        if (car == null) {
            String message = String.format(ExceptionMessages.CAR_NOT_FOUND, carModel);
            throw new IllegalArgumentException(message);
        }

        driver.addCar(car);
        return String.format(OutputMessages.CAR_ADDED, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        Race race = raceRepository.getByName(raceName);
        if (race == null) {
            String message = String.format(ExceptionMessages.RACE_NOT_FOUND, raceName);
            throw new IllegalArgumentException(message);
        }

        Driver driver = checkDriveExists(driverName);

        race.addDriver(driver);
        return String.format(OutputMessages.DRIVER_ADDED, driverName, raceName);
    }

    @Override
    public String startRace(String raceName) {
        Race race = raceRepository.getByName(raceName);
        if (race == null) {
            String message = String.format(ExceptionMessages.RACE_NOT_FOUND, raceName);
            throw new IllegalArgumentException(message);
        }

        if (race.getDrivers().size() < 3) {
            String message = String.format(ExceptionMessages.RACE_INVALID, raceName, MINIMUM_DRIVERS_REQUIRED);
            throw new IllegalArgumentException(message);
        }

        Collection<Driver> drivers = race.getDrivers();
        int laps = race.getLaps();

        List<Driver> winners = drivers.stream()
                .sorted((l, r) ->
                        Double.compare(r.getCar().calculateRacePoints(laps), l.getCar().calculateRacePoints(laps)))
                .limit(3)
                .collect(Collectors.toList());

        raceRepository.remove(race);

        String first = String.format(OutputMessages.DRIVER_FIRST_POSITION, winners.get(0).getName(), raceName);
        String second = String.format(OutputMessages.DRIVER_SECOND_POSITION, winners.get(1).getName(), raceName);
        String third = String.format(OutputMessages.DRIVER_THIRD_POSITION, winners.get(2).getName(), raceName);

        StringBuilder sb = new StringBuilder();
        sb.append(first)
                .append(System.lineSeparator())
                .append(second)
                .append(System.lineSeparator())
                .append(third);

        return sb.toString();
    }

    @Override
    public String createRace(String name, int laps) {
        Race race = new RaceImpl(name, laps);

        if (raceRepository.getByName(name) != null) {
            String message = String.format(ExceptionMessages.RACE_EXISTS, name);
            throw new IllegalArgumentException(message);
        }

        raceRepository.add(race);
        return String.format(OutputMessages.RACE_CREATED, name);
    }

    private Driver checkDriveExists(String driverName) {
        Driver driver = driverRepository.getByName(driverName);
        if (driver == null) {
            String message = String.format(ExceptionMessages.DRIVER_NOT_FOUND, driverName);
            throw new IllegalArgumentException(message);
        }
        return driver;
    }
}
