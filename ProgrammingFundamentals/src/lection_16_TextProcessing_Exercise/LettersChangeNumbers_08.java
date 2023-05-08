package lection_16_TextProcessing_Exercise;

import java.util.Scanner;

public class LettersChangeNumbers_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputNums = scanner.nextLine().split("\\s+");

        double totalSum = 0;
        for (int i = 0; i < inputNums.length; i++) {
            String currentText = inputNums[i];
            totalSum += calculationResult(currentText);
        }
        System.out.printf("%.2f", totalSum);
    }

    public static double calculationResult(String text) {
        double number = 0;
        char firstLetter = text.charAt(0);
        char lastLetter = text.charAt(text.length() - 1);
        text = text.replace(firstLetter, ' ');
        text = text.replace(lastLetter, ' ');
        number = Double.parseDouble(text.trim());

        if (Character.isUpperCase(firstLetter)) {
            //ASCII 'A': 65; alphabet position: 1; 65 - 64
            int position = (int) firstLetter - 64;
            number = number / position;
        } else {
            //ASCII 'a': 97; alphabet position: 1; 97 - 96
            int position = (int) firstLetter - 96;
            number = number * position;
        }

        if (Character.isUpperCase(lastLetter)) {
            int position = (int) lastLetter - 64;
            number = number - position;
        } else {
            int position = (int) lastLetter - 96;
            number = number + position;
        }

        return number;
    }
}
