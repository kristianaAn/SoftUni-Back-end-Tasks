package orderbyAge;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Person> allPeople = new ArrayList<>();

        while (!input.equals("End")) {
            String personName = input.split(" ")[0];
            String personId = input.split(" ")[1];
            int personAge = Integer.parseInt(input.split(" ")[2]);

            Person person = new Person(personName, personId, personAge);
            allPeople.add(person);

            input = scanner.nextLine();
        }

        allPeople.sort(Comparator.comparing(Person::getAge));

        allPeople.forEach(entry -> System.out.printf("%s with ID: %s is %d years old.%n", entry.getName(), entry.getID(), entry.getAge()));
    }
}
