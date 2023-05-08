package Lection_03_DataTypes_Lab;

import java.util.Scanner;

public class ConvertMetersToKilometers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        short meters = Short.parseShort(scanner.nextLine());

        double km = meters * 1.0 / 1000;

        System.out.printf("%.2f", km);
    }
}
