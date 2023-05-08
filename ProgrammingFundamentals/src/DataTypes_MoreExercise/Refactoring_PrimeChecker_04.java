package DataTypes_MoreExercise;

import java.util.Scanner;

public class Refactoring_PrimeChecker_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 2; i <= n; i++) {
            boolean isTrue = true;
            for (int divisor = 2; divisor < i; divisor++) {
                if (i % divisor == 0) {
                    isTrue = false;
                    break;
                }
            }
            System.out.printf("%d -> %b%n", i, isTrue);
        }
    }
}
