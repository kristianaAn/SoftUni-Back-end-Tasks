package lection_05_SetsAndMapsAdvanced_lab;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Voina_NumberGame_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<Integer> firstPlayerDeck = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        LinkedHashSet<Integer> secondPlayerDeck = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        for (int i = 0; i < 50; i++) {

            if (firstPlayerDeck.isEmpty()) {
                System.out.println("Second player win!");
                return;
            } else if (secondPlayerDeck.isEmpty()) {
                System.out.println("First player win!");
                return;
            }

            int firstPlayerFirstCard = firstPlayerDeck.iterator().next();
            int secondPlayerFirstCard = secondPlayerDeck.iterator().next();

            firstPlayerDeck.remove(firstPlayerFirstCard);
            secondPlayerDeck.remove(secondPlayerFirstCard);

            if (firstPlayerFirstCard > secondPlayerFirstCard) {
                firstPlayerDeck.add(firstPlayerFirstCard);
                firstPlayerDeck.add(secondPlayerFirstCard);

            } else if (secondPlayerFirstCard > firstPlayerFirstCard) {
                secondPlayerDeck.add(firstPlayerFirstCard);
                secondPlayerDeck.add(secondPlayerFirstCard);

            }

        }
        if (firstPlayerDeck.size() > secondPlayerDeck.size()) {
            System.out.println("First player win!");
        } else if (secondPlayerDeck.size() > firstPlayerDeck.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
