package Lection_13_AssociativeArrays_lab;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountRealNumbers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        Map<Double, Integer> numbersMap = new TreeMap<>();

        for (int i = 0; i < numbers.length; i++) {
            double currentNumKey = numbers[i];
            numbersMap.putIfAbsent(currentNumKey,0);
            int currentValue = numbersMap.get(currentNumKey);
            numbersMap.put(currentNumKey, currentValue + 1);

            //Integer keyValue = numbersMap.get(currentNumKey);
            //if (numbersMap.containsKey(currentNumKey)) {
            //  numbersMap.put(currentNumKey, keyValue + 1);
            // } else {
            //   numbersMap.put(currentNumKey, 1);
            // }
        }

        for (Map.Entry<Double, Integer> entry : numbersMap.entrySet()) {
            System.out.printf("%.0f -> %d%n", entry.getKey(), entry.getValue());
        }

    }
}
