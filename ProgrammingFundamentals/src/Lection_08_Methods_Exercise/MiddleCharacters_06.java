package Lection_08_Methods_Exercise;

import java.util.Scanner;

public class MiddleCharacters_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        printMiddleChar(input);

    }
    public static void printMiddleChar (String text) {
        //четно -> dogs
        if (text.length() % 2 != 0) {
            System.out.println(text.charAt(text.length() / 2));
        } else {
            int firstMiddleIndex = (text.length() / 2) - 1;
            int secondMiddleIndex = text.length() / 2;
            System.out.println(text.charAt(firstMiddleIndex) + "" + text.charAt(secondMiddleIndex));
        }
    }
}
