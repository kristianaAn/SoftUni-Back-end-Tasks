package lection_09_FunctionalProgramming_lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        Predicate<String> startsWithUpperLetter = e -> Character.isUpperCase(e.charAt(0));

        List<String> upperCase = Arrays.stream(input).filter(startsWithUpperLetter).collect(Collectors.toList());

        System.out.println(upperCase.size());
        upperCase.stream().forEach(System.out::println);
    }
}
