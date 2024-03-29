package christmasPastryShop.repositories;

import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.repositories.interfaces.CocktailRepository;

import java.util.*;

public class CocktailRepositoryImpl implements CocktailRepository<Cocktail> {
    private Map<String, Cocktail> models;

    public CocktailRepositoryImpl() {
        this.models = new LinkedHashMap<>();
    }

    @Override
    public Cocktail getByName(String name) {
        return this.models.get(name);
    }

    @Override
    public Collection<Cocktail> getAll() {
        return Collections.unmodifiableCollection(models.values());
    }

    @Override
    public void add(Cocktail cocktail) {
        this.models.putIfAbsent(cocktail.getName(), cocktail);
    }
}
