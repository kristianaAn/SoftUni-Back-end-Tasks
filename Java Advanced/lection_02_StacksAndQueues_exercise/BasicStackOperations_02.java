package lection_02_StacksAndQueues_exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] elements = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int nElementsToPush = elements[0];
        int sElementsToPop = elements[1];
        int xElementToFind = elements[2];
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> numberStack = new ArrayDeque<>();

        for (int i = 0; i < nElementsToPush; i++) {
            numberStack.push(numbers[i]);
        }

        for (int i = 0; i < sElementsToPop; i++) {
            numberStack.pop();
        }

        if (numberStack.isEmpty()) {
            System.out.println("0");
        } else if (numberStack.contains(xElementToFind)) {
            System.out.println("true");
        } else {
            System.out.println(minNumber(numberStack));
        }

    }

    public static int minNumber(ArrayDeque<Integer> numbers) {
        int minValue = Integer.MAX_VALUE;
        for (Integer number : numbers) {
            if (number < minValue) {
                minValue = number;
            }
        }
        return minValue;
    }
}
