package lection_02_StacksAndQueues_exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersWithAStack_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> numberStack = new ArrayDeque<>();

        for (int i = 0; i < numbers.length; i++) {
            numberStack.push(numbers[i]);
        }

        while (!numberStack.isEmpty()) {
            System.out.print(numberStack.pop() + " ");
        }
    }
}
