package lection_12_DefiningClasses_Exercise_PokémonTrainer_06;

import java.util.List;
import java.util.stream.Collectors;

public class Trainer {
    private String name;
    private int badgesCount;
    private List<Pokemon> pokemonsCollection;

    public Trainer(String name, int badgesCount, List<Pokemon> pokemonsCollection) {
        this.name = name;
        this.badgesCount = badgesCount;
        this.pokemonsCollection = pokemonsCollection;
    }

    public void decreaseHealth(List<Pokemon> pokemonsCollection) {
        for (Pokemon pokemon : pokemonsCollection) {
            int initialHealth = pokemon.getHealth();
            initialHealth -= 10;
            pokemon.setHealth(initialHealth);
        }
    }

    public void adjustPokemonsCollection(List<Pokemon> pokemonsCollection) {
        pokemonsCollection = pokemonsCollection.stream().filter(pokemon -> pokemon.getHealth() > 0).collect(Collectors.toList());
        setPokemonsCollection(pokemonsCollection);
    }

    @Override
    public String toString() {
        return String.format(name + " " + badgesCount + " " + pokemonsCollection.size());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBadgesCount() {
        return badgesCount;
    }

    public void setBadgesCount(int badgesCount) {
        this.badgesCount = badgesCount;
    }

    public List<Pokemon> getPokemonsCollection() {
        return pokemonsCollection;
    }

    public void setPokemonsCollection(List<Pokemon> pokemonsCollection) {
        this.pokemonsCollection = pokemonsCollection;
    }
}
