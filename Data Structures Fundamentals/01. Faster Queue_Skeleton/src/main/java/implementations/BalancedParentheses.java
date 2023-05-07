package implementations;

import interfaces.Solvable;

public class BalancedParentheses implements Solvable {
    private String parentheses;
    private ArrayDeque<Character> openParenthesesQueue;

    public BalancedParentheses(String parentheses) {
        this.parentheses = parentheses;
        this.openParenthesesQueue = new ArrayDeque<>();
    }

    @Override
    public Boolean solve() {
        boolean areBalanced = false;

        for (int i = 0; i < parentheses.length(); i++) {

            char currentSymbol = parentheses.charAt(i);

            if (currentSymbol == '(' || currentSymbol == '{' || currentSymbol == '[') {
                openParenthesesQueue.offer(currentSymbol);

            } else if (currentSymbol == ')' || currentSymbol == '}' || currentSymbol == ']') {

                if (openParenthesesQueue.isEmpty()) {
                    areBalanced = false;
                    break;
                }

                char lastOpen = openParenthesesQueue.poll();

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
        return areBalanced;
    }
}
