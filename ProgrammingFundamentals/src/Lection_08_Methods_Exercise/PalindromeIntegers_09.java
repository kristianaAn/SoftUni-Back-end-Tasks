package Lection_08_Methods_Exercise;

import java.util.Scanner;

public class PalindromeIntegers_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String currentNum = input;

            if (isPalindrome(currentNum)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }

            input = scanner.nextLine();
        }

    }
    public static boolean isPalindrome (String number) {
        String initialNumber = number;
        String reversedNum = "";
        for (int i = initialNumber.length() - 1; i >= 0; i--) {
            reversedNum += initialNumber.charAt(i);
        }
        if (number.equals(reversedNum)) {
            return true;
        } else {
            return false;
        }
    }
}
