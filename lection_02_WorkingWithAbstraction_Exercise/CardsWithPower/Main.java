package lection_02_WorkingWithAbstraction_Exercise.CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Rank rank = Rank.valueOf(scanner.nextLine());
        Suit suit = Suit.valueOf(scanner.nextLine());

        Card currentCard = new Card(rank.getPower() + suit.getPower());

        System.out.printf("Card name: %s of %s; Card power: %d", rank, suit, currentCard.getPower());
    }
}
