package Lection_09_Lists_Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numsList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();
        String command = "";


        while (!input.equals("end")) {
            if (input.split(" ")[0].contains("Contains")) {
                boolean isContained = false;
                int number = Integer.parseInt(input.split(" ")[1]);
                if (numsList.contains(number)) {
                    isContained = true;
                    System.out.println("Yes");
                } else {
                    System.out.println("No such number");
                }
            } else if (input.contains("Print even")) {
                printEvenNumbers(numsList);
            } else if (input.contains("Print odd")) {
                printOddNumbers(numsList);
            } else if (input.contains("Get sum")) {
                System.out.println(sumNumbersInList(numsList));
            } else if (input.split(" ")[0].contains("Filter")) {
                String symbol = input.split(" ")[1];
                int number = Integer.parseInt(input.split(" ")[2]);
                printNumbersPerComparison(numsList,symbol,number);
            }

            input = scanner.nextLine();
        }
        System.out.println();
    }
    public static void printEvenNumbers (List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 == 0) {
                System.out.print(numbers.get(i) + " ");
            }
        }
        System.out.println();
    }

    public static void printOddNumbers (List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 != 0) {
                System.out.print(numbers.get(i) + " ");
            }
        }
        System.out.println();
    }

    public static int sumNumbersInList (List<Integer> numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            int currentNum = numbers.get(i);
            sum += currentNum;
        }
        return sum;
    }

    public static void printNumbersPerComparison (List<Integer> numbers, String symbol, int numToCompare) {
        switch (symbol) {
            case "<":
                for (int i = 0; i < numbers.size(); i++) {
                    int currentNum = numbers.get(i);

                    if (currentNum < numToCompare) {
                        System.out.print(currentNum + " ");
                    }
                }
                System.out.println();
                break;
            case ">":
                for (int i = 0; i < numbers.size(); i++) {
                    int currentNum = numbers.get(i);

                    if (currentNum > numToCompare) {
                        System.out.print(currentNum + " ");
                    }
                }
                System.out.println();
                break;
            case "<=":
                for (int i = 0; i < numbers.size(); i++) {
                    int currentNum = numbers.get(i);

                    if (currentNum <= numToCompare) {
                        System.out.print(currentNum + " ");
                    }
                }
                System.out.println();
                break;
            case ">=":
                for (int i = 0; i < numbers.size(); i++) {
                    int currentNum = numbers.get(i);

                    if (currentNum >= numToCompare) {
                        System.out.print(currentNum + " ");
                    }
                }
                System.out.println();
                break;
        }
    }
}
