package lection_02_StacksAndQueues_exercise;

import java.net.Inet4Address;
import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nCommandsCount = Integer.parseInt(scanner.nextLine()); //N
        //"1 X" - Push the element X into the stack.
        //"2" - Delete the element present at the top of the stack.
        //"3" - Print the maximum element in the stack.

        ArrayDeque<Integer> numStack = new ArrayDeque<>();

        for (int i = 0; i < nCommandsCount; i++) {
            String input = scanner.nextLine();
            String command = input.split("\\s+")[0];

            if (command.equals("1")) {
                int numToAdd = Integer.parseInt(input.split("\\s+")[1]);
                numStack.push(numToAdd);
            } else if (command.equals("2")) {
                numStack.pop();
            } else if (command.equals("3")) {
                printMaxNumInStack(numStack);
            }
        }
    }
    public static void printMaxNumInStack (ArrayDeque<Integer> numStack) {
        int maxNum = Integer.MIN_VALUE;
        for (int num : numStack) {
            if (num > maxNum) {
                maxNum = num;
            }
        }
        System.out.println(maxNum);
    }
}
