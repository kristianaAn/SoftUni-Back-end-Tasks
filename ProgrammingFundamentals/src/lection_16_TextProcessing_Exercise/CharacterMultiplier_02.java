package lection_16_TextProcessing_Exercise;

import java.util.Scanner;

public class CharacterMultiplier_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputText = scanner.nextLine().split(" ");
        String firstWord = inputText[0];
        String secondWord = inputText[1];

        multiplicationCharResult(firstWord, secondWord);
    }

    public static void multiplicationCharResult(String word, String word2) {
        int result = 0;
        char[] firstWordArr = word.toCharArray();
        char[] secondWordArr = word2.toCharArray();

        if ((firstWordArr.length - 1) > (secondWordArr.length - 1)) {
            for (int i = 0; i < secondWordArr.length; i++) {
                result = result + (firstWordArr[i] * secondWordArr[i]);
            }

            for (int i = secondWordArr.length; i < firstWordArr.length; i++) {
                result += firstWordArr[i];
            }

        } else if ((firstWordArr.length - 1) < (secondWordArr.length - 1)) {
            for (int i = 0; i < firstWordArr.length; i++) {
                result = result + (firstWordArr[i] * secondWordArr[i]);
            }

            for (int i = firstWordArr.length; i < secondWordArr.length; i++) {
                result += secondWordArr[i];
            }

        } else {
            for (int i = 0; i < firstWordArr.length; i++) {
                result = result + (firstWordArr[i] * secondWordArr[i]);
            }
        }

        System.out.println(result);
    }
}
