package finalExam;

import java.util.Scanner;

public class Hogwarts_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String spellCiphered = scanner.nextLine();
        String input = scanner.nextLine();

        while (!input.equals("Abracadabra")) {
            if (input.contains("Abjuration")) {
                spellCiphered = spellCiphered.toUpperCase();
                System.out.println(spellCiphered);

            } else if (input.contains("Necromancy")) {
                spellCiphered = spellCiphered.toLowerCase();
                System.out.println(spellCiphered);

            } else if (input.contains("Illusion")) {
                int index = Integer.parseInt(input.split(" ")[1]);
                String letter = input.split(" ")[2];

                if (indexValidation(index, spellCiphered)) {
                    StringBuilder spellSb = new StringBuilder(spellCiphered);
                    spellSb.insert(index, letter);
                    spellSb.deleteCharAt(index + 1);
                    spellCiphered = spellSb.toString();
                    System.out.println("Done!");
                } else {
                    System.out.println("The spell was too weak.");
                }

            } else if (input.contains("Divination")) {
                String firstSubstring = input.split(" ")[1];
                String substitute = input.split(" ")[2];

                if (spellCiphered.contains(firstSubstring)) {
                    spellCiphered = spellCiphered.replace(firstSubstring, substitute);
                    System.out.println(spellCiphered);
                } else {
                    input = scanner.nextLine();
                    continue;
                }

            } else if (input.contains("Alteration")) {
                String substringToDelete = input.split(" ")[1];

                if (spellCiphered.contains(substringToDelete)) {
                    spellCiphered = spellCiphered.replace(substringToDelete, "");
                    System.out.println(spellCiphered);
                } else {
                    input = scanner.nextLine();
                    continue;
                }

            } else {
                System.out.println("The spell did not work!");
            }

            input = scanner.nextLine();
        }
    }

    public static boolean indexValidation(int index, String word) {
        return index >= 0 && index < word.length();
    }
}
