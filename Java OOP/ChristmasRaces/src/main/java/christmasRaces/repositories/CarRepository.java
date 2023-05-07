package christmasRaces.repositories;

import christmasRaces.entities.cars.Car;
import christmasRaces.repositories.interfaces.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class CarRepository implements Repository<Car> {
    private Map<String, Car> models;

    public CarRepository() {
        models = new LinkedHashMap<>();
    }

    @Override
    public Car getByName(String name) {
        return models.get(name);
    }

    @Override
    public Collection<Car> getAll() {
        return Collections.unmodifiableCollection(models.values());
    }

    @Override
    public void add(Car car) {
        models.putIfAbsent(car.getModel(), car);
    }

    @Override
    public boolean remove(Car car) {
        return models.remove(car.getModel(), car);
    }
}
