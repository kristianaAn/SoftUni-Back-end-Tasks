package lection_05_SetsAndMapsAdvanced_lab;

import java.util.*;

public class ProductShop_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, LinkedHashMap<String, Double>> productAndPriceMap = new TreeMap<>();

        while (!input.equals("Revision")) {
            String shop = input.split(", ")[0];
            String product = input.split(", ")[1];
            double price = Double.parseDouble(input.split(", ")[2]);

            if (!productAndPriceMap.containsKey(shop)) {
                productAndPriceMap.put(shop, new LinkedHashMap<>());
            }
            productAndPriceMap.get(shop).put(product, price);

            input = scanner.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Double>> shop : productAndPriceMap.entrySet()) {
            System.out.println(shop.getKey() + "->");
            for (Map.Entry<String, Double> product : shop.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", product.getKey(), product.getValue());
            }
        }
    }
}
