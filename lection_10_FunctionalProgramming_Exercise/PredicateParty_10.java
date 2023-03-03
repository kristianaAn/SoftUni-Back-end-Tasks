package lection_10_FunctionalProgramming_Exercise;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> guestList = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        String input = scanner.nextLine();

        Set<String> criteriaFilter = new HashSet<>();

        while (!input.equals("Party!")) {
            String doubleOrRemove = input.split(" ")[0];
            String criteria = input.split(" ")[1];
            String parameter = input.split(" ")[2];

            if (doubleOrRemove.equals("Double")) {
                criteriaFilter.add(doubleOrRemove + " " + criteria + " " + parameter);
            } else {
                criteriaFilter.remove(doubleOrRemove + " " + criteria + " " + parameter);
            }

            input = scanner.nextLine();
        }

    }

    private static Function<String, String> getFunction(String filter) {
        String[] wholeFilter = filter.split(" ");
        String doubleOrRemove = wholeFilter[0];
        String criteria = wholeFilter[1];
        String parameter = wholeFilter[2];
        int length = Integer.parseInt(parameter);

        if (doubleOrRemove.equals("Double")) {
           if (criteria.equals("StartsWith")) {
             return s -> s.startsWith(parameter) + " " + s;
           } else if (criteria.equals("EndsWith")) {
             return s -> s.endsWith(parameter) + " " + s;
           } else {
             return s -> (s.length() == length) + " " + s;
           }

        }
        return null;
    }
}
