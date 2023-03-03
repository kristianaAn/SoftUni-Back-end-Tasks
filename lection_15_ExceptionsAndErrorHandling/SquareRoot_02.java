package lection_15_ExceptionsAndErrorHandling;

import java.util.Scanner;

public class SquareRoot_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int number = Integer.parseInt(scanner.nextLine());
            double sqrtResult = calculateSqrt(number);
            System.out.printf("%.2f%n", sqrtResult);
        } catch (Exception e) {
            System.out.println("Invalid");
        } finally {
            System.out.println("Goodbye");
        }
    }

    public static double calculateSqrt(int number) {
        if (number < 0) {
            throw new ArithmeticException("Invalid");
        }
        return Math.sqrt(number);
    }
}
