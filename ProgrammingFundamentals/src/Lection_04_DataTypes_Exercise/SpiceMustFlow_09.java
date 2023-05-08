package Lection_04_DataTypes_Exercise;

import java.util.Scanner;

public class SpiceMustFlow_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startingYield = Integer.parseInt(scanner.nextLine());
        int harvest = 0;
        int currentYieldAfterWorkers = 0;
        int days = 0;

        while (startingYield >= 100) {
            days++;
            currentYieldAfterWorkers = startingYield - 26;
            harvest += currentYieldAfterWorkers;

            startingYield -= 10;
        }

        if (harvest >= 26) {
            harvest = harvest - 26;
        }

        System.out.printf("%d%n", days);
        System.out.printf("%d%n", harvest);
    }
}
