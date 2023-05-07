package lection_04_MultidimensionalArrays_exercise;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }

        int primaryDiagonalSum = getPrimaryDiagonalSum(matrix);
        int secondaryDiagonalSum = getSecondaryDiagonalSum(matrix);

        System.out.println(Math.abs(primaryDiagonalSum - secondaryDiagonalSum));
    }

    private static int getSecondaryDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int columns = 0; columns < matrix[rows].length; columns++) {
                int currentNum = matrix[rows][columns];
                if (rows == matrix.length - columns - 1) {
                    sum += currentNum;
                }
            }
        }
        return sum;
    }

    private static int getPrimaryDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int columns = 0; columns < matrix[rows].length; columns++) {
                int currentNum = matrix[rows][columns];
                if (rows == columns) {
                    sum += currentNum;
                }
            }
        }
        return sum;
    }
}
