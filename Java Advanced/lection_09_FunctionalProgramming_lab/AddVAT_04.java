package lection_09_FunctionalProgramming_lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AddVAT_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> pricesToIncrease = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        Function<Double, Double> vatAdded = e -> e * 1.2;

        System.out.println("Prices with VAT:");

        pricesToIncrease.stream().map(vatAdded).forEach(e -> System.out.printf("%.2f%n", e));
    }
}
