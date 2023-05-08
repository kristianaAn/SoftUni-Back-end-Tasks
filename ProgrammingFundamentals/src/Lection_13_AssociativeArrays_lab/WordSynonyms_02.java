package Lection_13_AssociativeArrays_lab;

import java.util.*;

public class WordSynonyms_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<String> > wordsAndSynonyms = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String keyWord = scanner.nextLine();
            String synonymValue = scanner.nextLine();

            if (!wordsAndSynonyms.containsKey(keyWord)) {
                wordsAndSynonyms.put(keyWord, new ArrayList<>());
                wordsAndSynonyms.get(keyWord).add(synonymValue);
            } else {
                wordsAndSynonyms.get(keyWord).add(synonymValue);
            }
        }

        for (Map.Entry<String, List<String>> entry : wordsAndSynonyms.entrySet()) {
            System.out.println("" + entry.getKey() + " - " + String.join(", ", entry.getValue()));
        }

    }
}
