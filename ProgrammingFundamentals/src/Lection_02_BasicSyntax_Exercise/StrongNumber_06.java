package Lection_02_BasicSyntax_Exercise;

import java.util.Scanner;

public class StrongNumber_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        int currentNum = number;
        int productSum = 0;

        while (number > 0) {
            int lastDigit = number % 10;
            int currentProduct = 1;
            for (int i = 1; i <= lastDigit; i++) {
                currentProduct = currentProduct * i;
            }
            productSum += currentProduct;
            number = number / 10;
        }

        if (productSum == currentNum) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
