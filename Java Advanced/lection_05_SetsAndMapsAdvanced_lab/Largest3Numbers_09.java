package lection_05_SetsAndMapsAdvanced_lab;

import java.util.*;
import java.util.stream.Collectors;

public class Largest3Numbers_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        numbers.stream().sorted(
                (left, right) -> right.compareTo(left)
        )
                .limit(3)
                .forEach(num -> System.out.print(num + " "));
    }
}
