package lection_05_SetsAndMapsAdvanced_lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] inputNums = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
        Map<Double, Integer> occurrenceCount = new LinkedHashMap<>();

        for (int i = 0; i < inputNums.length; i++) {
            double currentNum = inputNums[i];
            if (!occurrenceCount.containsKey(currentNum)) {
                occurrenceCount.put(currentNum, 1);
            } else {
                int currentOccurrences = occurrenceCount.get(currentNum);
                occurrenceCount.put(currentNum, currentOccurrences + 1);
            }
        }

        for (Map.Entry<Double, Integer> entry : occurrenceCount.entrySet()) {
            System.out.printf("%.1f -> %d%n", entry.getKey(), entry.getValue());
        }

    }
}
