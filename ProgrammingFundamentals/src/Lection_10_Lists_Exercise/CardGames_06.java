package Lection_10_Lists_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardGames_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstPlayerCards = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondPlayerCards = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int firstPlayerCurrCard = 0;
        int secondPlayerCurrCard = 0;

        while (firstPlayerCards.size() > 0 && secondPlayerCards.size() > 0) {
            for (int i = 0; i <= firstPlayerCards.size() - 1; i++) {
                firstPlayerCurrCard = firstPlayerCards.get(i);
                for (int j = 0; j <= secondPlayerCards.size() - 1; j++) {
                    secondPlayerCurrCard = secondPlayerCards.get(i);
                    if (firstPlayerCurrCard > secondPlayerCurrCard) {
                        firstPlayerCards.add(firstPlayerCurrCard);
                        firstPlayerCards.remove(0);
                        firstPlayerCards.add(secondPlayerCurrCard);
                        secondPlayerCards.remove(i);
                        i--;
                        break;
                    } else if (secondPlayerCurrCard > firstPlayerCurrCard) {
                        secondPlayerCards.add(secondPlayerCurrCard);
                        secondPlayerCards.remove(0);
                        secondPlayerCards.add(firstPlayerCurrCard);
                        firstPlayerCards.remove(i);
                        i--;
                        break;
                    } else {
                        firstPlayerCards.remove(i);
                        secondPlayerCards.remove(i);
                        i--;
                        break;
                    }
                }
            }

        }
        printWinnerAndSum(firstPlayerCards, secondPlayerCards);

    }

    public static void printWinnerAndSum(List<Integer> firstPlayer, List<Integer> secondPlayer) {
        if (firstPlayer.size() > secondPlayer.size()) {
            System.out.print("First player wins! ");
            int sum = 0;
            for (int num : firstPlayer) {
                sum += num;
            }
            System.out.printf("Sum: %d", sum);
        } else {
            System.out.print("Second player wins! ");
            int sum = 0;
            for (int num : secondPlayer) {
                sum += num;
            }
            System.out.printf("Sum: %d", sum);
        }
    }
}
