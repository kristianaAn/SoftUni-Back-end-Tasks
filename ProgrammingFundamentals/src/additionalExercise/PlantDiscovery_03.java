package additionalExercise;

import java.util.*;

public class PlantDiscovery_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> plantAndRarity = new LinkedHashMap<>();
        Map<String, List<Double>> plantsAndRating = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String plantInfo = scanner.nextLine();
            String plant = plantInfo.split("<->")[0];
            int rarity = Integer.parseInt(plantInfo.split("<->")[1]);

            if (!plantAndRarity.containsKey(plant) && !plantsAndRating.containsKey(plant)) {
                plantAndRarity.put(plant, rarity);
                plantsAndRating.put(plant, new ArrayList<>());
            }
        }

        String input = scanner.nextLine();

        while (!input.equals("Exhibition")) {

            String command = input.split(":\\s+")[0];
            String substringCommand = input.split(":\\s+")[1];

            if (command.equals("Rate")) {
                String plant = substringCommand.split("\\s+-\\s+")[0];
                double rating = Double.parseDouble(substringCommand.split("\\s+-\\s+")[1]);

                if (plantAndRarity.containsKey(plant)) {
                    plantsAndRating.get(plant).add(rating);
                } else {
                    System.out.println("error");
                    input = scanner.nextLine();
                    continue;
                }

            } else if (command.equals("Update")) {
                String plant = substringCommand.split("\\s+-\\s+")[0];
                int rarity = Integer.parseInt(substringCommand.split("\\s+-\\s+")[1]);

                if (plantAndRarity.containsKey(plant)) {
                    plantAndRarity.put(plant, rarity);
                } else {
                    System.out.println("error");
                    input = scanner.nextLine();
                    continue;
                }

            } else if (command.equals("Reset")) {
                String plant = substringCommand;

                if (plantAndRarity.containsKey(plant)) {
                    plantsAndRating.put(plant, new ArrayList<>());
                    plantsAndRating.get(plant).add(0.00);
                } else {
                    System.out.println("error");
                    input = scanner.nextLine();
                    continue;
                }
            }

            input = scanner.nextLine();
        }

        Map<String, Double> plantsAndAverageRating = new LinkedHashMap<>();

        for (Map.Entry<String, List<Double>> entry : plantsAndRating.entrySet()) {
            double sum = 0;
            double average = 0;
            List<Double> ratings = entry.getValue();
            for (double rate : ratings) {
                sum += rate;
            }
            average = sum / ratings.size();
            plantsAndAverageRating.put(entry.getKey(), average);
        }

        System.out.println("Plants for the exhibition: ");

        for (Map.Entry<String, Integer> integerEntry : plantAndRarity.entrySet()) {
            for (Map.Entry<String, Double> entry : plantsAndAverageRating.entrySet()) {
                if (integerEntry.getKey().equals(entry.getKey())) {
                    System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", entry.getKey(), integerEntry.getValue(), entry.getValue());
                }
            }

        }
    }
}
