package lection_14_AssociativeArrays_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<Character, Integer> symbolsCount = new LinkedHashMap<>();

        for (char symbol : input.toCharArray()) {
            if (symbol == ' ') {
                continue;
            }
            
            if (symbolsCount.containsKey(symbol)) {
                int currentKeyValue = symbolsCount.get(symbol);
                symbolsCount.put(symbol, currentKeyValue + 1);
            } else {
                symbolsCount.put(symbol, 1);
            }
        }

        symbolsCount.entrySet().forEach(entry -> System.out.printf("%c -> %d%n", entry.getKey(), entry.getValue()));
    }
}
