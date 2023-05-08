package Lection_07_Methods_Lab;

import java.util.Scanner;

public class MathOperations_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number1 = Integer.parseInt(scanner.nextLine());
        char arithmeticSymbol = scanner.nextLine().charAt(0);
        int number2 = Integer.parseInt(scanner.nextLine());

        System.out.println(getResultFromArithmeticOperation(number1, arithmeticSymbol, number2));

    }
    public static int getResultFromArithmeticOperation (int num1, char operator, int num2) {
        int result = 0;
        switch (operator) {
            case '+':
                int resultAdding = num1 + num2;
                result = resultAdding;
                break;
            case '/':
                int resultDividing = num1 / num2;
                result = resultDividing;
                break;
            case '-':
                int resultSubtracting = num1 - num2;
                result = resultSubtracting;
                break;
            case '*':
                int resultMultiplying = num1 * num2;
                result = resultMultiplying;
                break;
        }
        return result;
    }
}
