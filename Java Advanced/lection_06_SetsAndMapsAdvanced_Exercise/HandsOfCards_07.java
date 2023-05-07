package lection_06_SetsAndMapsAdvanced_Exercise;

import java.util.*;

public class HandsOfCards_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, Set<String>> playerAndCards = new LinkedHashMap<>();


        while (!input.equals("JOKER")) {
            String playerName = input.split(":\\s+")[0];
            String cards = input.split(":\\s+")[1];
            String[] cardsArr = cards.split(", ");

            Set<String> cardsSet = new LinkedHashSet<>();
            cardsSet.addAll(Arrays.asList(cardsArr));

            if (!playerAndCards.containsKey(playerName)) {
                playerAndCards.put(playerName, cardsSet);
            } else {
                Set<String> currentCardsSet = playerAndCards.get(playerName);
                currentCardsSet.addAll(cardsSet);
                playerAndCards.put(playerName, currentCardsSet);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Set<String>> entry : playerAndCards.entrySet()) {
            String name = entry.getKey();
            int points = getPoints(entry.getValue());
            System.out.printf("%s: %d%n", name, points);
        }
    }

    private static int getPoints(Set<String> cardValues) {
        int points = 0;
        int sum = 0;
        Map<Character, Integer> cardsPoints = new HashMap<>();
        mapPoints(cardsPoints);

        for (String card : cardValues) {
            if (card.startsWith("10")) {
                char cardType = card.charAt(2);
                points = 10 * cardsPoints.get(cardType);
            } else {
                char cardPower = card.charAt(0);
                char cardType = card.charAt(1);
                points = cardsPoints.get(cardPower) * cardsPoints.get(cardType);
            }
            sum += points;
        }
        return sum;
    }

    private static Map<Character, Integer> mapPoints (Map<Character, Integer> points) {

        points.put('2', 2);
        points.put('3', 3);
        points.put('4', 4);
        points.put('5', 5);
        points.put('6', 6);
        points.put('7', 7);
        points.put('8', 8);
        points.put('9', 9);
        points.put('J', 11);
        points.put('Q', 12);
        points.put('K', 13);
        points.put('A', 14);
        points.put('S', 4);
        points.put('H', 3);
        points.put('D', 2);
        points.put('C', 1);
        return points;
    }
}
