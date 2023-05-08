package additionalExercise;

import java.util.*;

public class Pirates_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, List<Integer>> cityPopulationGoldMap = new LinkedHashMap<>();

        while (!input.equals("Sail")) {
            String city = input.split("\\|\\|")[0];
            int population = Integer.parseInt(input.split("\\|\\|")[1]);
            int gold = Integer.parseInt(input.split("\\|\\|")[2]);

            if (!cityPopulationGoldMap.containsKey(city)) {
                cityPopulationGoldMap.put(city, new ArrayList<>());
                cityPopulationGoldMap.get(city).add(population);
                cityPopulationGoldMap.get(city).add(gold);
            } else {
                List<Integer> populationAndGold = cityPopulationGoldMap.get(city);
                int updatedPopulation = populationAndGold.get(0) + population;
                int updatedGold = populationAndGold.get(1) + gold;
                cityPopulationGoldMap.put(city, new ArrayList<>());
                cityPopulationGoldMap.get(city).add(updatedPopulation);
                cityPopulationGoldMap.get(city).add(updatedGold);
            }

            input = scanner.nextLine();
        }

        String events = scanner.nextLine();

        while (!events.equals("End")) {
            if (events.contains("Plunder")) {
                String town = events.split("=>")[1];
                int people = Integer.parseInt(events.split("=>")[2]);
                int gold = Integer.parseInt(events.split("=>")[3]);

                System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, gold, people);

                int initialPeople = cityPopulationGoldMap.get(town).get(0);
                int initialGold = cityPopulationGoldMap.get(town).get(1);

                if (initialPeople - people <= 0 || initialGold - gold <= 0) {
                    cityPopulationGoldMap.remove(town);
                    System.out.printf("%s has been wiped off the map!%n", town);
                } else {
                    cityPopulationGoldMap.put(town, new ArrayList<>());
                    cityPopulationGoldMap.get(town).add(initialPeople - people);
                    cityPopulationGoldMap.get(town).add(initialGold - gold);
                }

            } else if (events.contains("Prosper")) {
                String town = events.split("=>")[1];
                int gold = Integer.parseInt(events.split("=>")[2]);

                if (gold <= 0) {
                    System.out.println("Gold added cannot be a negative number!");
                } else {
                    int initialGold = cityPopulationGoldMap.get(town).get(1);
                    int updatedGold = initialGold + gold;
                    cityPopulationGoldMap.get(town).set(1, updatedGold);
                    System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", gold, town, updatedGold);
                }
            }

            events = scanner.nextLine();
        }

        if (cityPopulationGoldMap.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", cityPopulationGoldMap.size());
            cityPopulationGoldMap.entrySet().forEach(entry -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",
                    entry.getKey(), entry.getValue().get(0), entry.getValue().get(1)));
        }
    }
}
