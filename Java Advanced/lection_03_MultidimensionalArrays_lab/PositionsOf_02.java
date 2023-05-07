package lection_03_MultidimensionalArrays_lab;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] matrixCharacteristics = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int matrixCount = matrixCharacteristics[0];
        int symbolsPerMatrixCount = matrixCharacteristics[1];

        int[][] matrix = new int[matrixCount][symbolsPerMatrixCount];

        for (int i = 0; i < matrix.length; i++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            matrix[i] = numbers;
        }

        int numberToFind = Integer.parseInt(scanner.nextLine());

        boolean isFound = false;
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int columns = 0; columns < matrix[rows].length; columns++) {
                int currentNum = matrix[rows][columns];
                if (currentNum == numberToFind) {
                    isFound = true;
                    System.out.println(rows + " " + columns);
                }
            }
        }
        if (!isFound) {
            System.out.println("not found");
        }
    }
}
