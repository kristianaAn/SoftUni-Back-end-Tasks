package lection_12_DefiningClasses_Exercise_PokémonTrainer_06;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Trainer> trainerMap = new LinkedHashMap<>();

        Trainer trainer = null;
        while (!input.equals("Tournament")) {
            //{TrainerName} {PokemonName} {PokemonElement} {PokemonHealth}
            String trainerName = input.split("\\s+")[0];
            String pokemonName = input.split("\\s+")[1];
            String pokemonElement = input.split("\\s+")[2];
            int pokemonHealth = Integer.parseInt(input.split("\\s+")[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);


            if (!trainerMap.containsKey(trainerName)) {
                trainer = new Trainer(trainerName, 0, new ArrayList<>());
                List<Pokemon> currentList = trainer.getPokemonsCollection();
                currentList.add(pokemon);
                trainer.setPokemonsCollection(currentList);
                trainerMap.put(trainerName, trainer);
            } else {
                trainer = trainerMap.get(trainerName);
                List<Pokemon> initialList = trainer.getPokemonsCollection();
                initialList.add(pokemon);
                trainer.setPokemonsCollection(initialList);
                trainerMap.put(trainerName, trainer);
            }

            input = scanner.nextLine();
        }

        String newInput = scanner.nextLine();

        while (!newInput.equals("End")) {
            //Fire", "Water", and "Electricity"
            switch (newInput) {
                case "Fire":
                    extractedFire(trainerMap);
                    break;
                case "Water":
                    extractedWater(trainerMap);
                    break;
                case "Electricity":
                    extractedElectricity(trainerMap);
                    break;
            }

            newInput = scanner.nextLine();
        }

        trainerMap.entrySet()
                .stream()
                .sorted((l, r) -> Integer.compare(r.getValue().getBadgesCount(), l.getValue().getBadgesCount()))
                .forEach(entry -> System.out.println(entry.getValue().toString()));

    }


    private static void extractedFire(Map<String, Trainer> trainerMap) {
        for (Map.Entry<String, Trainer> entry : trainerMap.entrySet()) {
            boolean isContained = isFire(entry);
            if (isContained) {
                int badgesCount = entry.getValue().getBadgesCount();
                badgesCount++;
                entry.getValue().setBadgesCount(badgesCount);
            } else {
                entry.getValue().decreaseHealth(entry.getValue().getPokemonsCollection());
                entry.getValue().adjustPokemonsCollection(entry.getValue().getPokemonsCollection());
            }

        }
    }

    private static void extractedWater(Map<String, Trainer> trainerMap) {
        for (Map.Entry<String, Trainer> entry : trainerMap.entrySet()) {
            boolean isContained = isWater(entry);
            if (isContained) {
                int badgesCount = entry.getValue().getBadgesCount();
                badgesCount++;
                entry.getValue().setBadgesCount(badgesCount);
            } else {
                entry.getValue().decreaseHealth(entry.getValue().getPokemonsCollection());
                entry.getValue().adjustPokemonsCollection(entry.getValue().getPokemonsCollection());
            }

        }
    }

    private static void extractedElectricity(Map<String, Trainer> trainerMap) {
        for (Map.Entry<String, Trainer> entry : trainerMap.entrySet()) {
            boolean isContained = isElectricity(entry);
            if (isContained) {
                int badgesCount = entry.getValue().getBadgesCount();
                badgesCount++;
                entry.getValue().setBadgesCount(badgesCount);
            } else {
                entry.getValue().decreaseHealth(entry.getValue().getPokemonsCollection());
                entry.getValue().adjustPokemonsCollection(entry.getValue().getPokemonsCollection());
            }

        }
    }


    private static boolean isFire(Map.Entry<String, Trainer> entry) {
        return entry.getValue()
                .getPokemonsCollection()
                .stream()
                .anyMatch(poke -> poke.getElement().equals("Fire"));
    }

    private static boolean isWater(Map.Entry<String, Trainer> entry) {
        return entry.getValue()
                .getPokemonsCollection()
                .stream()
                .anyMatch(poke -> poke.getElement().equals("Water"));
    }

    private static boolean isElectricity(Map.Entry<String, Trainer> entry) {
        return entry.getValue()
                .getPokemonsCollection()
                .stream()
                .anyMatch(poke -> poke.getElement().equals("Electricity"));
    }
}
