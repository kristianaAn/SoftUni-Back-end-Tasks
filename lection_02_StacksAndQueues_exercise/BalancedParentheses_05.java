package lection_02_StacksAndQueues_exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String parentheses = scanner.nextLine();
        ArrayDeque<Character> openParenthesesStack = new ArrayDeque<>();

        boolean areBalanced = false;
        for (int i = 0; i < parentheses.length(); i++) {

            char currentSymbol = parentheses.charAt(i);

            if (currentSymbol == '(' || currentSymbol == '{' || currentSymbol == '[') {
                openParenthesesStack.push(currentSymbol);

            } else if (currentSymbol == ')' || currentSymbol == '}' || currentSymbol == ']') {

                if (openParenthesesStack.isEmpty()) {
                    areBalanced = false;
                    break;
                }

                char lastOpen = openParenthesesStack.pop();

                if (currentSymbol == ')' && lastOpen == '(') {
                    areBalanced = true;

                } else if (currentSymbol == '}' && lastOpen == '{') {
                    areBalanced = true;

                } else if (currentSymbol == ']' && lastOpen == '[') {
                    areBalanced = true;

                } else {
                    areBalanced = false;
                    break;
                }
            }
        }
        System.out.println(areBalanced ? "YES" : "NO");
    }
}
