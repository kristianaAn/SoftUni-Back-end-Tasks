package christmasPastryShop.repositories;

import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.repositories.interfaces.BoothRepository;

import java.util.*;

public class BoothRepositoryImpl implements BoothRepository<Booth> {
    private Map<Integer, Booth> models;

    public BoothRepositoryImpl() {
        this.models = new LinkedHashMap<>();
    }

    @Override
    public Booth getByNumber(int number) {
        return this.models.get(number);
    }

    @Override
    public Collection<Booth> getAll() {
        return Collections.unmodifiableCollection(models.values());
    }

    @Override
    public void add(Booth booth) {
        this.models.putIfAbsent(booth.getBoothNumber(), booth);
    }
}
