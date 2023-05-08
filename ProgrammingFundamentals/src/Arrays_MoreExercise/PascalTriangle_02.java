package Arrays_MoreExercise;

import java.util.Scanner;

public class PascalTriangle_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] numbers = {1};

        System.out.println("1");

        for (int i = 1; i < n; i++) {
            int[] incrementedNums = new int[numbers.length + 1];
            incrementedNums[0] = numbers[0];
            incrementedNums[incrementedNums.length - 1] = numbers[numbers.length - 1];
            for (int j = 1; j < incrementedNums.length - 1; j++) {
                incrementedNums[j] = numbers[j - 1] + numbers[j];
            }
            numbers = incrementedNums;
            printArray(incrementedNums);
            System.out.println();
        }
    }

    public static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
