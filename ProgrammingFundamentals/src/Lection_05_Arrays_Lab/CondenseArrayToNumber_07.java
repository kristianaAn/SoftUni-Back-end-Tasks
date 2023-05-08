package Lection_05_Arrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class CondenseArrayToNumber_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] initialArray = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int sumToAdd = 0;
        while (initialArray.length > 1) {
            int[] newArr = new int[initialArray.length - 1];
            for (int i = 0; i < initialArray.length - 1; i++) {
                sumToAdd = initialArray[i] + initialArray[i + 1];
                newArr[i] = sumToAdd;
            }
            initialArray = newArr;
        }
        System.out.println(initialArray[0]);
    }
}
