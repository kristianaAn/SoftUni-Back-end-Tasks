package Lection_09_Lists_Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List <Integer> numsList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int numberOfIterations = numsList.size() / 2;

        for (int i = 1; i <= numberOfIterations; i++) {
            int firstAddable = numsList.get(i - 1);
            int secondAddable = numsList.get(numsList.size() - 1);

            numsList.set(i - 1, firstAddable + secondAddable);
            numsList.remove(numsList.size() - 1);
        }

        for (int num : numsList) {
            System.out.print(num + " ");
        }
    }
}
