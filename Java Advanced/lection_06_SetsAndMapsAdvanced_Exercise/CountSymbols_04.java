package lection_06_SetsAndMapsAdvanced_Exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        Map<Character, Integer> letterOccurrenceCount = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {
            char currentLetter = text.charAt(i);

            if (!letterOccurrenceCount.containsKey(currentLetter)) {
                letterOccurrenceCount.put(currentLetter, 1);
            } else {
                int currentCount = letterOccurrenceCount.get(currentLetter);
                letterOccurrenceCount.put(currentLetter, currentCount + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : letterOccurrenceCount.entrySet()) {
            System.out.printf("%c: %d time/s%n", entry.getKey(), entry.getValue());
        }

    }
}
