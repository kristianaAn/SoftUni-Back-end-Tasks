package lection_04_MultidimensionalArrays_exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int rows = Integer.parseInt(input.split("\\s+")[0]);//N
        int columns = Integer.parseInt(input.split("\\s+")[1]);//M

        int[][] matrix = new int[rows][columns];

        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        printSummedMatrix3x3(matrix);
    }

    private static void printSummedMatrix3x3(int[][] matrix) {
        int maxSum = Integer.MIN_VALUE;
        int[][] newMatrix = new int[3][3];
        for (int rows = 0; rows < matrix.length - 2; rows++) {
            for (int columns = 0; columns < matrix[rows].length - 2; columns++) {
                int currentSum = matrix[rows][columns] + matrix[rows][columns + 1] + matrix[rows][columns + 2]
                        + matrix[rows + 1][columns] + matrix[rows + 1][columns + 1] + matrix[rows + 1][columns + 2]
                        + matrix[rows + 2][columns] + matrix[rows + 2][columns + 1] + matrix[rows + 2][columns + 2];

                if (currentSum > maxSum) {
                    maxSum = currentSum;

                    newMatrix[0][0] = matrix[rows][columns];
                    newMatrix[0][1] = matrix[rows][columns + 1];
                    newMatrix[0][2] = matrix[rows][columns + 2];
                    newMatrix[1][0] = matrix[rows + 1][columns];
                    newMatrix[1][1] = matrix[rows + 1][columns + 1];
                    newMatrix[1][2] = matrix[rows + 1][columns + 2];
                    newMatrix[2][0] = matrix[rows + 2][columns];
                    newMatrix[2][1] = matrix[rows + 2][columns + 1];
                    newMatrix[2][2] = matrix[rows + 2][columns + 2];
                }
            }
        }

        System.out.println("Sum = " + maxSum);
        for (int[] row : newMatrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
