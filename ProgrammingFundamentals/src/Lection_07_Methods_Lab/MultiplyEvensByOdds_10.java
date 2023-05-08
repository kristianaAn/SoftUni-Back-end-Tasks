package Lection_07_Methods_Lab;

import java.util.Scanner;

public class MultiplyEvensByOdds_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        System.out.println(Math.abs(getMultiply(number)));

    }
    public static int getEvensSum (int num) {
        int evenSum = 0;
        int currentNum = Math.abs(num);
        while (currentNum > 0) {
            int lastDigit = currentNum % 10;
            if (lastDigit % 2 == 0) {
                evenSum += lastDigit;
            }
            currentNum = currentNum / 10;
        }
        return evenSum;
    }

    public static int getOddSum (int num) {
        int oddSum = 0;
        int currentNum = Math.abs(num);

        while (currentNum > 0) {
            int lastDigit = currentNum % 10;
            if (lastDigit % 2 != 0) {
                oddSum += lastDigit;
            }
            currentNum = currentNum / 10;
        }
        return oddSum;
    }

    public static int getMultiply (int result) {
        int multiplier1 = getEvensSum(result);
        int multiplier2 = getOddSum(result);
        result = multiplier1 * multiplier2;
        return result;
    }
}
