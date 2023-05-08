package lection_16_TextProcessing_Exercise;

import java.util.Scanner;

public class ValidUsernames_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] usernames = scanner.nextLine().split(", ");

        for (int i = 0; i <= usernames.length - 1; i++) {
            String currentUsername = usernames[i];
            if (isUsernameValid(currentUsername)) {
                System.out.println(currentUsername);
            }
        }
    }

    public static boolean isUsernameValid(String username) {
        if (username.length() < 3 || username.length() > 16) {
            //Has a length between 3 and 16 characters.
            return false;
        }

        //Contains only letters, numbers, hyphens, and underscores.
        for (int i = 0; i <= username.length() - 1; i++) {
            char currentSymbol = username.charAt(i);
            if (!Character.isLetterOrDigit(currentSymbol) && currentSymbol != '-' && currentSymbol != '_') {
                return false;
            }
        }
        return true;
    }
}
