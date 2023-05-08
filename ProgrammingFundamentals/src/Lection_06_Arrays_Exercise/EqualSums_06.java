package Lection_06_Arrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class EqualSums_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arrayInt = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        boolean isSpecial = false;
        for (int i = 0; i < arrayInt.length; i++) {

            int leftSum = 0;
            int rightSum = 0;
            for (int leftNums = 0; leftNums < i; leftNums++) {
                leftSum += arrayInt[leftNums];
            }

            for (int rightNums = i + 1; rightNums < arrayInt.length; rightNums++) {
                rightSum += arrayInt[rightNums];
            }

            if (rightSum == leftSum) {
                isSpecial = true;
                System.out.println(i);
            }
        }
        if (!isSpecial) {
            System.out.println("no");
        }
    }
}
