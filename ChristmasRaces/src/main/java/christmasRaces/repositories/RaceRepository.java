package christmasRaces.repositories;

import christmasRaces.entities.races.Race;
import christmasRaces.repositories.interfaces.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class RaceRepository implements Repository<Race> {
    private Map<String, Race> models;

    public RaceRepository() {
        models = new LinkedHashMap<>();
    }

    @Override
    public Race getByName(String name) {
        return models.get(name);
    }

    @Override
    public Collection<Race> getAll() {
        return Collections.unmodifiableCollection(models.values());
    }

    @Override
    public void add(Race race) {
        models.putIfAbsent(race.getName(), race);
    }

    @Override
    public boolean remove(Race race) {
        return models.remove(race.getName(), race);
    }
}
