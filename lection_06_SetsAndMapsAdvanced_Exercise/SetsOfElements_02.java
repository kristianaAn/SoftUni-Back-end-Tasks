package lection_06_SetsAndMapsAdvanced_Exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int firstSetLength = Integer.parseInt(input.split("\\s+")[0]);
        int secondSetLength = Integer.parseInt(input.split("\\s+")[1]);

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();
        Set<Integer> outputSet = new LinkedHashSet<>();

        for (int i = 0; i < firstSetLength; i++) {
            firstSet.add(Integer.parseInt(scanner.nextLine()));
        }

        for (int j = 0; j < secondSetLength; j++) {
            secondSet.add(Integer.parseInt(scanner.nextLine()));
        }

        for (int num : firstSet) {
            for (int number : secondSet) {
                if (num == number) {
                    outputSet.add(num);
                }
            }
        }

        for (Integer integer : outputSet) {
            System.out.print(integer + " ");
        }

    }
}
