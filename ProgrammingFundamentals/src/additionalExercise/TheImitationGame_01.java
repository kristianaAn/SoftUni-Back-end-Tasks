package additionalExercise;

import java.util.Scanner;

public class TheImitationGame_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String encryptedWord = scanner.nextLine();
        StringBuilder encryptedWordSb = new StringBuilder(encryptedWord);

        String input = scanner.nextLine();

//"ChangeAll {substring} {replacement}":
//Changes all occurrences of the given substring with the replacement text
        while (!input.equals("Decode")) {

            if (input.contains("Move")) {
                int numOfLettersToMove = Integer.parseInt(input.split("\\|")[1]);

                for (int i = 0; i < numOfLettersToMove; i++) {
                    char currentLetter = encryptedWordSb.charAt(i);
                    encryptedWordSb.append(currentLetter);
                }

                encryptedWordSb.delete(0, numOfLettersToMove);

            } else if (input.contains("Insert")) {
                int index = Integer.parseInt(input.split("\\|")[1]);
                String valueToInsert = input.split("\\|")[2];

                encryptedWordSb.insert(index, valueToInsert);

            } else if (input.contains("ChangeAll")) {
                String substringToBeReplaced = input.split("\\|")[1];
                String replacementPhrase = input.split("\\|")[2];

                String newEncryptedWord = encryptedWordSb.toString().replace(substringToBeReplaced, replacementPhrase);
                encryptedWordSb = new StringBuilder(newEncryptedWord);

            }

            input = scanner.nextLine();
        }

        System.out.printf("The decrypted message is: %s", encryptedWordSb);
    }
}
