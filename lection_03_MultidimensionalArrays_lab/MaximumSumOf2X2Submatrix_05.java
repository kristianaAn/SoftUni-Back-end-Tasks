package lection_03_MultidimensionalArrays_lab;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2X2Submatrix_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] characteristics = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int countOfArrays = characteristics[0];
        int countOfSymbolsPerArray = characteristics[1];

        int[][] matrix = new int[countOfArrays][countOfSymbolsPerArray];

        for (int rows = 0; rows < countOfArrays; rows++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

            matrix[rows] = numbers;
        }

        printSummedMatrix2x2(matrix);

    }

    public static void printSummedMatrix2x2(int[][] matrix) {
        int biggestSum = Integer.MIN_VALUE;
        int[][]outcomeMatrix = new int[2][2];
        for (int rows = 0; rows < matrix.length - 1; rows++) {
            for (int columns = 0; columns < matrix[rows].length - 1; columns++) {
                int currentSum = matrix[rows][columns] + matrix[rows][columns + 1]
                           + matrix[rows + 1][columns] + matrix[rows + 1][columns + 1];

                if (currentSum >= biggestSum) {
                    biggestSum = currentSum;
                    outcomeMatrix[0][0] = matrix[rows][columns];
                    outcomeMatrix[0][1] = matrix[rows][columns + 1];
                    outcomeMatrix[1][0] = matrix[rows + 1][columns];
                    outcomeMatrix[1][1] = matrix[rows + 1][columns + 1];
                }
            }
        }
        for (int[] row : outcomeMatrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

        System.out.println(biggestSum);
    }
}
