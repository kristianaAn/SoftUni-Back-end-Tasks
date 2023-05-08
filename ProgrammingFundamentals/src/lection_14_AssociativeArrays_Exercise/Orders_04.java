package lection_14_AssociativeArrays_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, Double> productAndPrice = new LinkedHashMap<>();
        Map<String, Integer> productAndQty = new LinkedHashMap<>();

        while (!input.equals("buy")) {
            String product = input.split(" ")[0];
            double price = Double.parseDouble(input.split(" ")[1]);
            int quantity = Integer.parseInt(input.split(" ")[2]);

            if (!productAndPrice.containsKey(product)) {
                productAndPrice.put(product, price);
            } else {
                productAndPrice.put(product, price);
            }

            if (!productAndQty.containsKey(product)) {
                productAndQty.put(product, quantity);
            } else {
                productAndQty.put(product, productAndQty.get(product) + quantity);
            }

            input = scanner.nextLine();
        }

        Map<String, Double> resultingMap = new LinkedHashMap<>();
        for (Map.Entry<String, Double> entry : productAndPrice.entrySet()) {
            for (Map.Entry<String, Integer> integerEntry : productAndQty.entrySet()) {
                if (entry.getKey().equals(integerEntry.getKey())) {
                    double result = entry.getValue() * integerEntry.getValue();
                    resultingMap.put(entry.getKey(), result);
                }
            }
        }
        for (Map.Entry<String, Double> doubleEntry : resultingMap.entrySet()) {
            System.out.printf("%s -> %.2f%n", doubleEntry.getKey(), doubleEntry.getValue());
        }
    }
}
