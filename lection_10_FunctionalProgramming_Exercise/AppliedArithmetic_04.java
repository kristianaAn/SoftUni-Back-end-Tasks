package lection_10_FunctionalProgramming_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AppliedArithmetic_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> inputNums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        String commands = scanner.nextLine();
        Function<List<Integer>, List<Integer>> addNum = list -> list.stream().map(e -> e + 1).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> multiplyNum = list -> list.stream().map(e -> e * 2).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> subtractNum = list -> list.stream().map(e -> e - 1). collect(Collectors.toList());
        Consumer<List<Integer>> printer = list -> list.forEach(e -> System.out.print(e + " "));

        while (!commands.equals("end")) {
            switch (commands) {
                case "add":
                    inputNums = addNum.apply(inputNums);
                    break;
                case "multiply":
                    inputNums = multiplyNum.apply(inputNums);
                    break;
                case "subtract":
                    inputNums = subtractNum.apply(inputNums);
                    break;
                case "print":
                    printer.accept(inputNums);
                    System.out.println();
                    break;
            }

            commands = scanner.nextLine();
        }

    }
}
