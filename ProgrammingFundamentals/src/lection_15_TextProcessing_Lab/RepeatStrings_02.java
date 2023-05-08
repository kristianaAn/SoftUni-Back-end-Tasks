package lection_15_TextProcessing_Lab;

import java.util.Scanner;

public class RepeatStrings_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputWordsArr = scanner.nextLine().split(" ");

        for (int i = 0; i < inputWordsArr.length; i++) {
            String currentWord = inputWordsArr[i];
            int countIterations = currentWord.length();

            for (int j = 1; j <= countIterations; j++) {
                System.out.print(currentWord);
            }
        }
    }
}
