package lection_04_MultidimensionalArrays_exercise;

import java.util.Scanner;

public class FillTheMatrix_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        int matrixParameters = Integer.parseInt(input[0]);
        String method = input[1];
        int[][] filledMatrix = new int[matrixParameters][matrixParameters];

        if (method.equals("A")) {
            printMatrixThroughMethodA(filledMatrix);
        } else if (method.equals("B")) {
            printMatrixThroughMethodB(filledMatrix);
        }

    }

    private static void printMatrixThroughMethodB(int[][] filledMatrix) {
        int startNum = 1;

        for (int columns = 0; columns < filledMatrix.length; columns++) {
            if (columns % 2 == 0) {
                for (int rows = 0; rows < filledMatrix.length; rows++) {
                    filledMatrix[rows][columns] = startNum;
                    startNum++;
                }
            } else {
                for (int rows = filledMatrix.length - 1; rows >= 0; rows--) {
                    filledMatrix[rows][columns] = startNum;
                    startNum++;
                }
            }
        }
        for (int[] rows : filledMatrix) {
            for (int num : rows) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void printMatrixThroughMethodA(int[][] matrix) {
        int startNumber = 1;

        for (int columns = 0; columns < matrix.length; columns++) {
            for (int rows = 0; rows < matrix.length; rows++) {
                matrix[rows][columns] = startNumber;
                startNumber++;
            }
        }
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
