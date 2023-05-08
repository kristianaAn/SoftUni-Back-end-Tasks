package DataTypes_MoreExercise;

import java.util.Scanner;

public class BalancedBrackets_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int openBracketsCount = 0;
        int closedBracketsCount = 0;

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();

            if (input.equals("(")) {
                openBracketsCount++;
            } else if (input.equals(")")) {
                closedBracketsCount++;
            }
        }

        if (openBracketsCount == closedBracketsCount) {
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }
    }
}
