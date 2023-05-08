package Lection_08_Methods_Exercise;

import java.util.Scanner;

public class NxNMatrix_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        printNxNMatrix(number);

    }
    public static void printNxNMatrix (int num) {
        for (int columns = 1; columns <= num; columns++) {
            for (int rows = 1; rows <= num; rows++) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
