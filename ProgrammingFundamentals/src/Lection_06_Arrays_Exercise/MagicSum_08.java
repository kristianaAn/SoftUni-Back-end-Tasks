package Lection_06_Arrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MagicSum_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numsArray = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = Integer.parseInt(scanner.nextLine());

        boolean isEqual = false;
        for (int i = 0; i < numsArray.length; i++) {
            for (int j = i + 1; j < numsArray.length; j++) {
                if (numsArray[i] + numsArray[j] == n) {
                    isEqual = true;
                    System.out.print(numsArray[i] + " " + numsArray[j]);
                    System.out.println();
                } else {
                    isEqual = false;
                }
            }

        }
    }
}
