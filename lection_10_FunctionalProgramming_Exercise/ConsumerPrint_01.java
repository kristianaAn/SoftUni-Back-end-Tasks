package lection_10_FunctionalProgramming_Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Consumer<String> printNames = System.out::println;

        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(printNames);
    }
}
