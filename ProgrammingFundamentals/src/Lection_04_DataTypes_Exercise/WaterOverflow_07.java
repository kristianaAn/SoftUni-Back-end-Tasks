package Lection_04_DataTypes_Exercise;

import java.util.Scanner;

public class WaterOverflow_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int sumLiters = 0;
        for (int i = 1; i <= n; i++) {
            int liters = Integer.parseInt(scanner.nextLine());
            sumLiters += liters;

            if (sumLiters > 255) {
                sumLiters = sumLiters - liters;
                System.out.printf("Insufficient capacity!%n");
            }
        }
        System.out.println(sumLiters);
    }
}
