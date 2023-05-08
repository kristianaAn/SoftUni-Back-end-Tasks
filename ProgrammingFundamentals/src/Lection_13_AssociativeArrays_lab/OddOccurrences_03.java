package Lection_13_AssociativeArrays_lab;

import java.util.*;

public class OddOccurrences_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputWords = scanner.nextLine().split(" ");

        Map<String, Integer> repetitiveWords = new LinkedHashMap<>();

        for (int i = 0; i < inputWords.length; i++) {
            String currentWord = inputWords[i].toLowerCase();
            Integer keyValue = repetitiveWords.get(currentWord);

            if (!repetitiveWords.containsKey(currentWord)) {
                repetitiveWords.put(currentWord, 1);
            } else {
                repetitiveWords.put(currentWord,keyValue + 1);
            }
        }

        List<String> oddWords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : repetitiveWords.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                oddWords.add(entry.getKey());
            }
        }

        String output = String.join(", ", oddWords);
        System.out.println(output);
    }
}
