package Lection_07_Methods_Lab;

import java.util.Scanner;

public class Calculations_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        int number1 = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());


        switch (command) {
            case "add":
                printsAddedNumbers(number1, number2);
                break;
            case "multiply":
                printsMultipliedNumbers(number1, number2);
                break;
            case "subtract":
                printsSubtractedNumbers(number1, number2);
                break;
            case "divide":
                printsDividedNumbers(number1, number2);
                break;
        }

    }

    public static void printsAddedNumbers(int num1, int num2) {
        int result = num1 + num2;
        System.out.println(result);
    }

    public static void printsMultipliedNumbers(int num1, int num2) {
        int result = num1 * num2;
        System.out.println(result);
    }

    public static void printsSubtractedNumbers(int num1, int num2) {
        int result = num1 - num2;
        System.out.println(result);
    }

    public static void printsDividedNumbers(int num1, int num2) {
        int result = num1 / num2;
        System.out.println(result);
    }
}
