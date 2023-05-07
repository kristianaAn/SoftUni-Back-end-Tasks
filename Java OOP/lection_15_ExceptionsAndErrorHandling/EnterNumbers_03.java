package lection_15_ExceptionsAndErrorHandling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EnterNumbers_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbersInList = new ArrayList<>();
        int minNum = 1;

        while (numbersInList.size() < 10) {
            String input = scanner.nextLine();

            try {
                int number = Integer.parseInt(input);
                validateNumber(numbersInList, minNum, number);
            } catch (Exception e) {
                System.out.println("Invalid Number!");
            }

        }
        String output = numbersInList.stream().map(Object::toString).collect(Collectors.joining(", "));
        System.out.println(output);
    }

    private static void validateNumber(List<Integer> numbersInList, int minNum, int number) {
        if (number > minNum && number < 100) {
            numbersInList.add(number);
        } else if (!numbersInList.isEmpty()){
            System.out.printf("Your number is not in range %d - 100!%n", numbersInList.get(numbersInList.size() - 1));
        } else {
            System.out.println("Your number is not in range 1 - 100!");
        }
    }
}
