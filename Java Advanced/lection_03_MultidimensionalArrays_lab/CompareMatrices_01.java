package lection_03_MultidimensionalArrays_lab;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] matrix1Metrics = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int arraysCount = matrix1Metrics[0];
        int elementsPerArray = matrix1Metrics[1];

        int[][] firstMatrix = new int[arraysCount][elementsPerArray];

        for (int i = 0; i < arraysCount; i++) {
            int[] array1Metrics = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            firstMatrix[i] = array1Metrics;
        }

        int[]matrix2Metrics = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        arraysCount = matrix2Metrics[0];
        elementsPerArray = matrix2Metrics[1];

        int[][] secondMatrix = new int[arraysCount][elementsPerArray];

        for (int i = 0; i < arraysCount; i++) {
            int[] array2Metrics = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            secondMatrix[i] = array2Metrics;
        }

        if (areEqual(firstMatrix, secondMatrix)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }


    }
    public static boolean areEqual (int[][] matrix1, int[][] matrix2) {

        if (matrix1.length != matrix2.length) {
            return false;
        }

        for (int row = 0; row < matrix1.length; row++) {
            int[] matrix1array1 = matrix1[row];
            int[] matrix2array1 = matrix2[row];

            if (matrix1array1.length != matrix2array1.length) {
                return false;
            }

            for (int i = 0; i < matrix1array1.length; i++) {
                if (matrix1array1[i] != matrix2array1[i]) {
                    return false;
                }
            }
        } return true;
    }
}
