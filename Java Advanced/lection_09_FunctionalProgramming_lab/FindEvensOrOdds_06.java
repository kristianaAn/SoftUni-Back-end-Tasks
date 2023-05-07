package lection_09_FunctionalProgramming_lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class FindEvensOrOdds_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String range = scanner.nextLine();
        int start = Integer.parseInt(range.split("\\s+")[0]);
        int end = Integer.parseInt(range.split("\\s+")[1]);
        String evenOdd = scanner.nextLine();

        Predicate<Integer> even = e -> e % 2 == 0;
        Predicate<Integer> odd = e -> e % 2 != 0;
        List<Integer> numstoPrint = new ArrayList<>();

        for (int i = start; i <= end; i++) {
            if (evenOdd.equals("even")) {
                if (even.test(i)) {
                    numstoPrint.add(i);
                }
            } else {
                if (odd.test(i)) {
                    numstoPrint.add(i);
                }
            }
        }

        numstoPrint.forEach(e -> System.out.print(e + " "));
    }
}
