package lection_01_WorkingWithAbstraction_lab;

import java.util.Scanner;

public class RhombusOfStars_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int rows = 1; rows <= n; rows++) {
            printSpaces(n, rows);
            printStars(rows);
            System.out.println();
        }

        for (int rows = n - 1; rows > 0; rows--) {
            printSpaces(n,rows);
            printStars(rows);
            System.out.println();
        }

    }

    private static void printStars(int rows) {
        for (int i = 1; i <= rows; i++) {
            System.out.print("* ");
        }
    }

    private static void printSpaces(int n, int rows) {
        for (int interval = 1; interval <= n - rows; interval++) {
            System.out.print(" ");
        }
    }
}
