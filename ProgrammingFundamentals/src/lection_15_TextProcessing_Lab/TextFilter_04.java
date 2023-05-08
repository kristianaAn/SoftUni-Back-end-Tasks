package lection_15_TextProcessing_Lab;

import java.util.Scanner;

public class TextFilter_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] bannedWords = scanner.nextLine().split(", ");
        String textToRevise = scanner.nextLine();

        for (String banWord : bannedWords) {
            if (textToRevise.contains(banWord)) {
                 textToRevise = textToRevise.replace(banWord, starsToRepeat("*", banWord.length()));
            }
        }

        System.out.println(textToRevise);

    }
    public static String starsToRepeat (String text, int itersCount) {
        String revisedText = "";
        for (int i = 0; i < itersCount; i++) {
            revisedText += text;
        }
        return revisedText;
    }
}
