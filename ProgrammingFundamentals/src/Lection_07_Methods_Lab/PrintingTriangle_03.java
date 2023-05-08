package Lection_07_Methods_Lab;

import java.util.Scanner;

public class PrintingTriangle_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= number; i++) {
            printRows(1,i);
        }

        for (int i = number - 1; i >= 1; i--) {
            printRows(1,i);
        }
    }
    public static void printRows (int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
