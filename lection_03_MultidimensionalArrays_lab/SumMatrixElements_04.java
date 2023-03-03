package lection_03_MultidimensionalArrays_lab;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] characteristics = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int countOfArrays = characteristics[0];
        int countOfSymbolsPerArray = characteristics[1];

        int[][] matrix = new int[countOfArrays][countOfSymbolsPerArray];

        for (int rows = 0; rows < matrix.length; rows++) {
            int[] num = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

            matrix[rows] = num;
        }

        System.out.println(countOfArrays);
        System.out.println(countOfSymbolsPerArray);
        System.out.println(sumOfAllSymbols(matrix));
    }

    public static int sumOfAllSymbols(int[][] matrix) {

        int sum = 0;
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int columns = 0; columns < matrix[rows].length; columns++) {
                int currentNum = matrix[rows][columns];
                sum += currentNum;
            }
        }
        return sum;
    }
}
