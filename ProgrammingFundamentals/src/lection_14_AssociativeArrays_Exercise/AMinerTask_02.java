package lection_14_AssociativeArrays_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String resource = "";

        Map<String, Integer> materials = new LinkedHashMap<>();

        while (!input.equals("stop")) {
            resource = input;
            int quantity = Integer.parseInt(scanner.nextLine());

            if (!materials.containsKey(resource)) {
                materials.put(resource, quantity);
            } else {
                int currentMaterialQty = materials.get(resource);
                currentMaterialQty += quantity;
                materials.put(resource, currentMaterialQty);
            }

            input = scanner.nextLine();
        }

        materials.entrySet().forEach(entry -> System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue()));
    }
}
