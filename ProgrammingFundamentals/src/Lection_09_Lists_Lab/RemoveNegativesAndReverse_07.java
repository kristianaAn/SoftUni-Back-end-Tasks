package Lection_09_Lists_Lab;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RemoveNegativesAndReverse_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numsList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        for (int i = 0; i < numsList.size(); i++) {
            if (numsList.get(i) < 0) {
                numsList.remove(numsList.get(i));
                i--;
            }
        }

        Collections.reverse(numsList);

        if (numsList.size() <= 0) {
            System.out.println("empty");
        } else {
            for (int num : numsList) {
                System.out.print(num + " ");
            }
        }
    }
}
