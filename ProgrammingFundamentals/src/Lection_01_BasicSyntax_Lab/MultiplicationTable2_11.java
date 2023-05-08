package Lection_01_BasicSyntax_Lab;

import java.util.Scanner;

public class MultiplicationTable2_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        for (int i = secondNum; i <= 10; i++) {
            System.out.printf("%d X %d = %d%n", firstNum, i, firstNum * i);
        }
        if (secondNum > 10) {
            System.out.printf("%d X %d = %d%n", firstNum, secondNum, firstNum * secondNum);
        }
    }
}
