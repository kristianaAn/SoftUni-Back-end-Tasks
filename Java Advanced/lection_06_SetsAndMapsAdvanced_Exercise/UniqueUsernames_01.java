package lection_06_SetsAndMapsAdvanced_Exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Set<String> uniqueNames = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            String inputs = scanner.nextLine();
            uniqueNames.add(inputs);
        }

        for (String name : uniqueNames) {
            System.out.println(name);
        }
    }
}
