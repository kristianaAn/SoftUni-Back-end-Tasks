package Lection_08_Methods_Exercise;

import java.util.Scanner;

public class FactorialDivision_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number1 = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());

        long factorial1 = factorial1Calculation(number1);
        long factorial2 = factorial1Calculation(number2);
        double divisionResult = factorial1 * 1.0 / factorial2;
        System.out.printf("%.2f", divisionResult);

    }
    public static long factorial1Calculation (int num1) {
        long result = 1;
        for (int i = 1; i <= num1; i++) {
            result = result * i;
        }
        return result;
    }
}
