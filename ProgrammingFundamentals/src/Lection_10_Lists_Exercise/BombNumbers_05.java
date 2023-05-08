package Lection_10_Lists_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> inputNums = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int specialNumber = Integer.parseInt(scanner.next());
        int power = Integer.parseInt(scanner.next()); //3

        while (inputNums.contains(specialNumber)) {
            int indexOfSpecNum = inputNums.indexOf(specialNumber); // 5

            int right = Math.min(indexOfSpecNum + power, (inputNums.size() - 1)); // (8,5)
            int left = Math.max(0, indexOfSpecNum - power); //2

            for (int i = right; i >= left; i--) {
                inputNums.remove(i);
            }
        }

        printSumOfRemainingNums(inputNums);
    }


    public static void printSumOfRemainingNums(List<Integer> nums) {
        int result = 0;
        for (int i = 0; i <= nums.size() - 1; i++) {
            result += nums.get(i);
        }
        System.out.println(result);
    }
}
