package Lection_04_DataTypes_Exercise;

import java.util.Scanner;

public class PokeMon_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nPower = Integer.parseInt(scanner.nextLine());
        int mDistance = Integer.parseInt(scanner.nextLine());
        int yExhaustionFactor = Integer.parseInt(scanner.nextLine());

        int pokesCount = 0;
        int currentPower = nPower;

        while (currentPower >= mDistance) {
            currentPower = currentPower - mDistance;
            pokesCount++;

            if (currentPower == nPower * 0.5 && yExhaustionFactor > 0) {
                currentPower = currentPower / yExhaustionFactor;
            }
        }
        System.out.printf("%d%n", currentPower);
        System.out.printf("%d%n", pokesCount);
    }
}
