package lection_08_StreamsFilesAndDirectories_exercise;

import java.io.*;
import java.util.Locale;

public class CountCharacters_04 {
    public static void main(String[] args) throws IOException {
        int vowels = 0;
        int consonants = 0;
        int punctuation = 0;

        FileReader fr = new FileReader("resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt");
        PrintWriter pw = new PrintWriter(new FileWriter("resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/output.txt"));
        int oneByte = fr.read();

        while (oneByte >= 0) {
            char symbol = (char) (oneByte);

            if (isVowel(symbol)) {
                vowels++;
            } else if (isPunctuation(symbol)) {
                punctuation++;
            } else if (!Character.isWhitespace(symbol)) {
                consonants++;
            }

            oneByte = fr.read();
        }
        fr.close();
        pw.println("Vowels: " + vowels);
        pw.println("Consonants: " + consonants);
        pw.println("Punctuation: " + punctuation);

        pw.close();
    }

    private static boolean isPunctuation(char symbol) {
        return symbol == ',' || symbol == '.' || symbol == '!' || symbol == '?';
    }

    private static boolean isVowel(char symbol) {
        return symbol == 'a' || symbol == 'e' || symbol == 'o' || symbol == 'i' || symbol == 'u';
    }
}
