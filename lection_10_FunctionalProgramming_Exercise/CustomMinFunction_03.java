package lection_10_FunctionalProgramming_Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class CustomMinFunction_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> inputNums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Consumer<List<Integer>> printMinNum = list -> System.out.println(Collections.min(list));
        printMinNum.accept(inputNums);

    }
}
