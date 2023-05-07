package lection_01_StacksAndQueues_lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputNums = scanner.nextLine().split("\\s+");
        ArrayDeque<String> numbersStack = new ArrayDeque<>(); // 1 + 2 + 3

        for (int i = inputNums.length - 1; i >= 0; i--) {
            String currentSymbol = inputNums[i];
            numbersStack.push(currentSymbol);
        }

        while (numbersStack.size() > 1) {
            int firstNum = Integer.parseInt(numbersStack.pop());
            String operator = numbersStack.pop();
            int secondNum = Integer.parseInt(numbersStack.pop());
            int result = 0;

            if (operator.equals("+")) {
                result = firstNum + secondNum;
            } else if (operator.equals("-")) {
                result = firstNum - secondNum;
            }
            numbersStack.push(String.valueOf(result));
        }
        System.out.println(numbersStack.peek());
    }

}
