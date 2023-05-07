package viceCity.repositories.interfaces;

import viceCity.models.guns.Gun;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class GunRepository implements Repository<Gun> {
    private Collection<Gun> guns;

    public GunRepository() {
        this.guns = new ArrayList<>();
    }

    @Override
    public Collection<Gun> getModels() {
        return Collections.unmodifiableCollection(guns);
    }

    @Override
    public void add(Gun model) {
        if (!guns.contains(model)) {
            guns.add(model);
        }
    }

    @Override
    public boolean remove(Gun model) {
        return guns.remove(model);
    }

    @Override
    public Gun find(String name) {
        return guns.stream().filter(gun -> gun.getName().equals(name))
                .findFirst().get();
    }
}
