package lection_08_StreamsFilesAndDirectories_exercise;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCount_06 {
    public static void main(String[] args) throws IOException {
        Scanner wordScanner = new Scanner(new FileReader("resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/words.txt"));
        String[] wordsToSearch = wordScanner.nextLine().split("\\s+");
        PrintWriter pw = new PrintWriter(new FileWriter("resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/results.txt"));

        Map<String, Integer> mapWords = new LinkedHashMap<>();

        for (String words : wordsToSearch) {
            mapWords.put(words, 0);
        }

        Scanner textToSearch = new Scanner(new FileReader("resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/text.txt"));
        String currentWord = textToSearch.next();
        while (textToSearch.hasNext()) {
            if (mapWords.containsKey(currentWord)) {
                int value = mapWords.get(currentWord);
                mapWords.put(currentWord, value + 1);
            }

            currentWord = textToSearch.next();
        }

        mapWords.entrySet().stream().sorted((left, right) -> right.getValue().compareTo(left.getValue()))
                .forEach(entry -> pw.printf("%s - %d%n", entry.getKey(), entry.getValue()));
        pw.close();
        wordScanner.close();
        textToSearch.close();
    }
}
