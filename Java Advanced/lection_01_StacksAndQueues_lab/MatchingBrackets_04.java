package lection_01_StacksAndQueues_lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<Integer> openingBracketsStack = new ArrayDeque<>();
        ArrayDeque<Integer> closingBracketsQueue = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);
            if (currentSymbol == '(') {
                openingBracketsStack.push(i);
            } else if (currentSymbol == ')') {
                closingBracketsQueue.offer(i);
                printSubExpression(input, openingBracketsStack.pop(), closingBracketsQueue.poll());
            }
        }
    }
    public static void printSubExpression (String input, int startIndex, int endIndex) {
        System.out.println(input.substring(startIndex, endIndex + 1));
    }
}
