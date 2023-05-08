package lection_15_TextProcessing_Lab;

import java.util.Scanner;

public class DigitsLettersAndOther_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        StringBuilder digitStringBuilder = new StringBuilder();
        StringBuilder letterStringBuilder = new StringBuilder();
        StringBuilder otherStringBuilder = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);

            if (Character.isDigit(currentSymbol)) {
                digitStringBuilder.append(currentSymbol);
            } else if (Character.isLetter(currentSymbol)) {
                letterStringBuilder.append(currentSymbol);
            } else {
                otherStringBuilder.append(currentSymbol);
            }
        }
        System.out.println(digitStringBuilder);
        System.out.println(letterStringBuilder);
        System.out.println(otherStringBuilder);
    }
}
