package lection_12_DefiningClasses_Exercise_OpinionPoll_01;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> people = new TreeMap<>();

        for (int i = 1; i <= n; i++) {
            String[] inputData = scanner.nextLine().split("\\s+");
            String name = inputData[0];
            int age = Integer.parseInt(inputData[1]);

            Person person = new Person(name, age);

            if (person.getAge() > 30) {
                people.put(name, age);
            }
        }

        people.entrySet().forEach(person -> System.out.printf("%s - %d%n", person.getKey(), person.getValue()));
    }
}
