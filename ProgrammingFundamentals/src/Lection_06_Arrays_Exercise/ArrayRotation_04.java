package Lection_06_Arrays_Exercise;

import java.util.Scanner;

public class ArrayRotation_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputArr = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());
             //32 21 61 1

        for (int i = 1; i <= n; i++) {
            String toGoLast = inputArr[0];
            for (int j = 0; j < inputArr.length - 1; j++) {
                inputArr[j] = inputArr [j + 1];
            }
            inputArr [inputArr.length - 1] = toGoLast;
        }

        for (String symbol : inputArr) {
            System.out.print(symbol + " ");
        }
    }
}
