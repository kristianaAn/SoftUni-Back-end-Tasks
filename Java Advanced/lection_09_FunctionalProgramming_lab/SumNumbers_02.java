package lection_09_FunctionalProgramming_lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumNumbers_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nums = scanner.nextLine().split(", ");

        List<Integer> integerList = Arrays.stream(nums).map(Integer::parseInt).collect(Collectors.toList());

        System.out.println("Count = " + integerList.size());

        System.out.println("Sum = " + Arrays.stream(nums).mapToInt(Integer::parseInt).sum());

    }
}
