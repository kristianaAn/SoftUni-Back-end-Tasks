package lection_09_FunctionalProgramming_lab;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class FilterByAge_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> people = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String inputText = scanner.nextLine();
            String name = inputText.split(",\\s+")[0];
            int personAge = Integer.parseInt(inputText.split(",\\s+")[1]);
            people.put(name, personAge);
        }

        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();
        BiPredicate<Integer, Integer> ageComparison;

        if (condition.equals("younger")) {
            ageComparison = (personAge, filterAge) -> personAge <= filterAge;
        } else {
            ageComparison = (personAge, filterAge) -> personAge >= filterAge;
        }

        Consumer<Map.Entry<String, Integer>> printFormat;

        if (format.equals("age")) {
            printFormat = person -> System.out.println(person.getValue());
        } else if (format.equals("name")) {
            printFormat = person -> System.out.println(person.getKey());
        } else {
            printFormat = person -> System.out.printf("%s - %d%n", person.getKey(), person.getValue());
        }

        people.entrySet().stream()
                .filter(person -> ageComparison.test(person.getValue(), age))
                .forEach(printFormat);

    }
}
