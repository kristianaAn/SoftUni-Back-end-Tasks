package lection_14_AssociativeArrays_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LegendaryFarming_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> legendaryResources = new LinkedHashMap<>();
        legendaryResources.put("shards", 0);
        legendaryResources.put("fragments", 0);
        legendaryResources.put("motes", 0);

        Map<String, Integer> junkMaterials = new LinkedHashMap<>();

        boolean isWinning = false;

        while (!isWinning) {
            String[] resources = scanner.nextLine().split(" ");
            for (int i = 0; i < resources.length; i += 2) {
                int quantity = Integer.parseInt(resources[i]);
                String material = resources[i + 1].toLowerCase();

                if (material.equals("shards")) {
                    legendaryResources.put(material, legendaryResources.get(material) + quantity);
                } else if (material.equals("fragments")) {
                    legendaryResources.put(material, legendaryResources.get(material) + quantity);
                } else if (material.equals("motes")) {
                    legendaryResources.put(material, legendaryResources.get(material) + quantity);
                } else {
                    if (!junkMaterials.containsKey(material)) {
                        junkMaterials.put(material, quantity);
                    } else {
                        junkMaterials.put(material, junkMaterials.get(material) + quantity);
                    }
                }

                if (material.equals("shards") && legendaryResources.get(material) >= 250) {
                    isWinning = true;
                    System.out.println("Shadowmourne obtained!");
                    legendaryResources.put(material, legendaryResources.get(material) - 250);
                    break;
                } else if (material.equals("fragments") && legendaryResources.get(material) >= 250) {
                    isWinning = true;
                    System.out.println("Valanyr obtained!");
                    legendaryResources.put(material, legendaryResources.get(material) - 250);
                    break;
                } else if (material.equals("motes") && legendaryResources.get(material) >= 250) {
                    isWinning = true;
                    System.out.println("Dragonwrath obtained!");
                    legendaryResources.put(material, legendaryResources.get(material) - 250);
                    break;
                }
            }

        }
        if (isWinning) {
            legendaryResources.entrySet().forEach(entry -> System.out.printf("%s: %d%n", entry.getKey(), entry.getValue()));
            junkMaterials.entrySet().forEach(entry -> System.out.printf("%s: %d%n", entry.getKey(), entry.getValue()));
        }
    }
}
