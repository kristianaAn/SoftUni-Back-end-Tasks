package catHouse.entities.houses;

import catHouse.common.ConstantMessages;
import catHouse.common.ExceptionMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseHouse implements House {
    private String name;
    private int capacity;
    private Collection<Toy> toys;
    private Collection<Cat> cats;

    public BaseHouse(String name, int capacity) {
        setName(name);
        setCapacity(capacity);
        this.toys = new ArrayList<>();
        this.cats = new ArrayList<>();
    }

    public int sumSoftness() {
        return toys.stream().mapToInt(Toy::getSoftness).sum();
    }

    public void addCat(Cat cat) {
        if (getCats().size() >= capacity) {
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_CAT);
        }
        getCats().add(cat);
    }

    public void removeCat(Cat cat) {
        getCats().remove(cat);
    }

    public void buyToy(Toy toy) {
        getToys().add(toy);
    }

    public void feeding() {
        for (Cat cat : getCats()) {
            cat.eating();
        }
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" ").append(getClass().getSimpleName()).append(":")
                .append(System.lineSeparator())
                .append("Cats: ")
                .append(stringBuilderCatNames())
                .append(System.lineSeparator())
                .append("Toys: ").append(getToys().size()).append(" ")
                .append("Softness: ").append(sumSoftness());

        return sb.toString().trim();
    }

    private String stringBuilderCatNames() {
        StringBuilder add = new StringBuilder();
        if (getCats().isEmpty()) {
            add.append("none");
            return add.toString().trim();
        } else {
            for (Cat cat : getCats()) {
                add.append(cat.getName()).append(" ");
            }
            return add.toString().trim();
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public int getCapacity() {
        return this.getCats().size();
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Collection<Toy> getToys() {
        return this.toys;
    }

    public void setToys(Collection<Toy> toys) {
        this.toys = toys;
    }

    public Collection<Cat> getCats() {
        return this.cats;
    }

    public void setCats(Collection<Cat> cats) {
        this.cats = cats;
    }
}
