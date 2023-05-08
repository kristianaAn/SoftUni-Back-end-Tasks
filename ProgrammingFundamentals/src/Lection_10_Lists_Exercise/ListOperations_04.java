package Lection_10_Lists_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> inputNums = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            if (input.contains("Add")) {
                int numberToAdd = Integer.parseInt(input.split(" ")[1]);
                inputNums.add(numberToAdd);
            } else if (input.contains("Insert")) {
                int number = Integer.parseInt(input.split(" ")[1]);
                int index = Integer.parseInt(input.split(" ")[2]);
                if (isValid(index, inputNums)) {
                    inputNums.add(index, number);
                } else {
                    System.out.println("Invalid index");
                }
            } else if (input.contains("Remove")) {
                int indexToRemove = Integer.parseInt(input.split(" ")[1]);
                if (isValid(indexToRemove, inputNums)) {
                    inputNums.remove(indexToRemove);
                } else {
                    System.out.println("Invalid index");
                }
            } else if (input.contains("Shift left")) {
                int count = Integer.parseInt(input.split(" ")[2]);
                for (int i = 1; i <= count; i++) {
                    int lastNumToBe = inputNums.get(0);
                    inputNums.add(inputNums.size(), lastNumToBe);
                    inputNums.remove(0);
                }
            } else if (input.contains("Shift right")) {
                int count = Integer.parseInt(input.split(" ")[2]);
                for (int i = 1; i <= count; i++) {
                    int firstNumToBe = inputNums.get(inputNums.size() - 1);
                    inputNums.add(0, firstNumToBe);
                    inputNums.remove(inputNums.size() - 1);
                }
            }
            input = scanner.nextLine();
        }

        for (int num : inputNums) {
            System.out.print(num + " ");
        }
    }

    public static boolean isValid(int index, List<Integer> nums) {
        if (index >= 0 && index <= nums.size() - 1) {
            return true;
        } else {
            return false;
        }
    }
}
