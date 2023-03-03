package lection_03_MultidimensionalArrays_lab;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matrixParameter = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[matrixParameter][matrixParameter];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }


        int rows = 0;
        int columns = 0;

        while (rows < matrix.length && columns < matrix[rows].length) {
            System.out.print(matrix[rows][columns] + " ");
            rows++;
            columns++;
        }

        rows = matrix.length - 1; //2
        columns = 0;

        System.out.println();

        while (rows >= 0 && columns < matrix[rows].length) {
            //  2 >= 0   && 0 < 3
            System.out.print(matrix[rows][columns] + " ");
            columns++;
            rows--;
        }
    }
}
