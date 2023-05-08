package Lection_04_DataTypes_Exercise;

import java.util.Scanner;

public class PrintPartOfASCIITable_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstCharCode = Integer.parseInt(scanner.nextLine());
        int secondCharCode = Integer.parseInt(scanner.nextLine());

        for (int i = firstCharCode; i <= secondCharCode; i++) {
            char symbol = (char) i;
            System.out.print(symbol + " ");
        }
    }
}
