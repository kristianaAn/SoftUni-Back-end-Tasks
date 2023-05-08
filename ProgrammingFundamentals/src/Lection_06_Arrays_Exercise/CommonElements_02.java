package Lection_06_Arrays_Exercise;

import java.util.Scanner;

public class CommonElements_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] array1 = scanner.nextLine().split(" ");
        String [] array2 = scanner.nextLine().split(" ");

        for (String symbol : array2) {
            for (String symbol2 : array1) {
                if (symbol.equals(symbol2)) {
                    System.out.print(symbol + " ");
                    break;
                }
            }
        }
    }
}
