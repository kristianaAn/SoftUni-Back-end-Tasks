package lection_10_FunctionalProgramming_Exercise;

import java.util.*;
import java.util.stream.Collectors;

public class ReverseAndExclude_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> inputNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());

        Collections.reverse(inputNumbers);

        // inputNumbers.stream().filter(e -> e % n != 0).forEach(e -> System.out.print(e + " "));
        inputNumbers.removeIf(e -> e % n == 0);
        inputNumbers.forEach(e -> System.out.print(e + " "));
    }
}
