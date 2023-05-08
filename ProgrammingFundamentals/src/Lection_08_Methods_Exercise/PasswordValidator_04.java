package Lection_08_Methods_Exercise;

import java.util.Scanner;

public class PasswordValidator_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputPass = scanner.nextLine();
        //1.Password is inclusive - 6 – 10 characters
        //2.Consists only of letters and digits
        //3.Has at least 2 digits.

        //"Password must be between 6 and 10 characters";
        //"Password must consist only of letters and digits";
        //"Password must have at least 2 digits".

        if (isInclusive(inputPass) && isOnlyOfLettersAndDigits(inputPass) && hasAtLeast2Digits(inputPass)) {
            System.out.println("Password is valid");
        }
        if (!isInclusive(inputPass)) {
            System.out.println("Password must be between 6 and 10 characters");
        }
        if (!isOnlyOfLettersAndDigits(inputPass)) {
            System.out.println("Password must consist only of letters and digits");
        }
        if (!hasAtLeast2Digits(inputPass)) {
            System.out.println("Password must have at least 2 digits");
        }
    }

    public static boolean isInclusive(String password) {
        if (password.length() >= 6 && password.length() <= 10) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isOnlyOfLettersAndDigits(String password) {
        for (char symbol : password.toCharArray()) {
            if (!Character.isLetterOrDigit(symbol)) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasAtLeast2Digits(String password) {
        int digitsCount = 0;
        for (char symbol : password.toCharArray()) {
            if (Character.isDigit(symbol)) {
                digitsCount++;
            }
        }
        if (digitsCount >= 2) {
            return true;
        } else {
            return false;
        }
    }
}
