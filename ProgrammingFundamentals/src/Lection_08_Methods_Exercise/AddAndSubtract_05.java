package Lection_08_Methods_Exercise;

import java.util.Scanner;

public class AddAndSubtract_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number1 = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());
        int number3 = Integer.parseInt(scanner.nextLine());

        int totalResult = sumNumbers(number1, number2) - number3;

        System.out.println(totalResult);

    }

    public static int sumNumbers (int num1, int num2) {
        int result = num1 + num2;
        return result;
    }
}
