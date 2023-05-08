package Lection_02_BasicSyntax_Exercise;

import java.util.Scanner;

public class RageExpenses_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lostGamesCount = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        int headsetCount = lostGamesCount / 2;
        int mouseCont = lostGamesCount / 3;
        int keyboardCount = lostGamesCount / 6;
        int displayCount = lostGamesCount / 12;

        double totalCosts = (headsetCount * headsetPrice) + (mousePrice * mouseCont) +
                (keyboardCount * keyboardPrice) + (displayCount * displayPrice);

        System.out.printf("Rage expenses: %.2f lv.", totalCosts);
    }
}
