package shelter;

import java.util.ArrayList;
import java.util.List;

public class Shelter {
    private int capacity;
    private List<Animal> data;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Animal animal) {
        if (data.size() < capacity) {
            data.add(animal);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(animal -> animal.getName().equals(name));
    }

    public Animal getAnimal(String name, String caretaker) {
        Animal animalToReturn = data.stream()
                .filter(animal -> animal.getName().equals(name) && animal.getCaretaker().equals(caretaker))
                .findFirst()
                .orElse(null);
        return animalToReturn;
    }

    public Animal getOldestAnimal() {
        return data.stream()
                .max((f, s) -> Integer.compare(f.getAge(), s.getAge()))
                .get();
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics () {
        StringBuilder sb = new StringBuilder("The shelter has the following animals:");
        for (Animal animal : data) {
            sb.append(System.lineSeparator());
            sb.append(animal.getName())
                    .append(" ")
                    .append(animal.getCaretaker());
        }
        return sb.toString();
    }
}
