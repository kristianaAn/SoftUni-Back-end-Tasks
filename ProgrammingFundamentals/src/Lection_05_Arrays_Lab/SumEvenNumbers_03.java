package Lection_05_Arrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class SumEvenNumbers_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int evenNumsSum = 0;
        for (int i = 0; i <= numbers.length - 1; i++) {
            if (numbers[i] % 2 == 0) {
                evenNumsSum += numbers[i];
            }
        }

        System.out.println(evenNumsSum);
    }

}
