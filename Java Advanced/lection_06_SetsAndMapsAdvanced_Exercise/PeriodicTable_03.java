package lection_06_SetsAndMapsAdvanced_Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Set<String> uniqueElements = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] elements = scanner.nextLine().split("\\s+");

            uniqueElements.addAll(Arrays.asList(elements));
        }

        for (String uniqueElement : uniqueElements) {
            System.out.print(uniqueElement + " ");
        }
    }
}
