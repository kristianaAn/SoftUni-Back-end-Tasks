package lection_03_MultidimensionalArrays_lab;

import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfArrays = Integer.parseInt(scanner.nextLine());
        int countOfCharsPerMatrix = Integer.parseInt(scanner.nextLine());

        char[][] matrix1 = new char[countOfArrays][countOfCharsPerMatrix];
        for (int rows = 0; rows < countOfArrays; rows++) {
            for (int columns = 0; columns < countOfCharsPerMatrix; columns++) {
                char symbolToAdd = scanner.next().charAt(0);

                matrix1[rows][columns] = symbolToAdd;
            }
        }

        char[][] matrix2 = new char[countOfArrays][countOfCharsPerMatrix];

        for (int rows = 0; rows < countOfArrays; rows++) {
            for (int columns = 0; columns < countOfCharsPerMatrix; columns++) {
                char symbolToAdd = scanner.next().charAt(0);

                matrix2[rows][columns] = symbolToAdd;
            }
        }

        printOutcomeMatrix(matrix1, matrix2);
    }

    public static void printOutcomeMatrix(char[][] matrix1, char[][] matrix2) {
        for (int rows = 0; rows < matrix1.length; rows++) {
            for (int columns = 0; columns < matrix1[rows].length; columns++) {
                char symbol1ToCompare = matrix1[rows][columns];
                char symbol2ToCompare = matrix2[rows][columns];
                if (symbol1ToCompare == symbol2ToCompare) {
                    System.out.print(symbol1ToCompare + " ");
                } else {
                    System.out.print("*" + " ");
                }
            }
            System.out.println();
        }
    }
}
