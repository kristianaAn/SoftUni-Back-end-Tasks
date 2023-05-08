package Lection_08_Methods_Exercise;

import java.util.Scanner;

public class TopNumber_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            if (sumIsDivisibleBy8(i) && holdsAnOddDigit(i)) {
                System.out.println(i);
            }
        }


    }
    public static boolean sumIsDivisibleBy8 (int number) {
        int lastDigit = 0;
        int sum = 0;
         while (number > 0) {
             lastDigit = number % 10;
             sum += lastDigit;
             number = number / 10;
         }
         if (sum % 8 == 0) {
             return true;
         } else {
             return false;
         }
    }

    public static boolean holdsAnOddDigit (int num) {
        int lastDigit = 0;
        while (num > 0) {
            lastDigit = num % 10;
            if (lastDigit % 2 != 0) {
                return true;
            }
            num = num / 10;
        }
        return false;
    }
 }
