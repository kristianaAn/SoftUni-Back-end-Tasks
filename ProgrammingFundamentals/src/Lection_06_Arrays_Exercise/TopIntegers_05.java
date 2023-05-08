package Lection_06_Arrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arrayInt = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        boolean isTop = false;
        for (int i = 0; i < arrayInt.length; i++) {
            if (i == arrayInt.length - 1) {
                System.out.print(arrayInt[arrayInt.length - 1] + " ");
                break;
            }
            for (int second = i + 1; second < arrayInt.length; second++) {
                if (arrayInt[i] > arrayInt[second]) {
                    isTop = true;
                } else {
                    isTop = false;
                    break;
                }
            }
            if (isTop) {
                System.out.print(arrayInt[i] + " ");
            }
        }
    }
}
