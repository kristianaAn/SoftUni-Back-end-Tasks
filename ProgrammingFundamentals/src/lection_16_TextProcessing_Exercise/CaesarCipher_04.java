package lection_16_TextProcessing_Exercise;

import java.util.Scanner;

public class CaesarCipher_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        printEncryptedText(input);

    }
    public static void printEncryptedText (String text) {
        StringBuilder encryptedTxt = new StringBuilder();
        char encryptedChar = 0;
        for (int i = 0; i < text.length(); i++) {
            char currentSymbol = text.charAt(i);
            encryptedChar = (char) ((int) currentSymbol + 3);
            encryptedTxt.append(encryptedChar);
        }
        System.out.println(encryptedTxt);
    }
}
