package lection_15_ExceptionsAndErrorHandling;

import java.util.Scanner;

public class NumberInRange_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startNum = Integer.parseInt(String.valueOf(scanner.nextInt()));
        int endNum = Integer.parseInt(String.valueOf(scanner.nextInt()));
        scanner.nextLine();
        System.out.printf("Range: [%d...%d]%n", startNum, endNum);

        int validNum = validNumber(scanner, startNum, endNum);
        System.out.println("Valid number: " + validNum);

    }

    private static int validNumber(Scanner scanner, int startNum, int endNum) {
        while (true) {
            String input = scanner.nextLine();
            try {
                int parseInput = Integer.parseInt(input);
                if (parseInput >= startNum && parseInput <= endNum) {
                    return parseInput;
                }
            } catch (NumberFormatException e) {
            }
            System.out.println("Invalid number: " + input);
        }
    }
}
