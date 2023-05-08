package additionalExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> initialItems = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Craft!")) {
            if (input.contains("Collect")) {
                String itemToAdd = input.split(" - ")[1];

                if (!initialItems.contains(itemToAdd)) {
                    initialItems.add(itemToAdd);
                }

            } else if (input.contains("Drop")) {
                String itemToRemove = input.split(" - ")[1];

                initialItems.remove(itemToRemove);

            } else if (input.contains("Combine")) {
                String items = input.split(" - ")[1];
                String oldItem = items.split(":")[0];
                String newItem = items.split(":")[1];

                if (initialItems.contains(oldItem)) {
                    int indexOldItem = initialItems.indexOf(oldItem);
                    initialItems.add(indexOldItem + 1, newItem);
                }

            } else if (input.contains("Renew")) {
                String itemToBeRenewed = input.split(" - ")[1];

                if (initialItems.contains(itemToBeRenewed)) {
                    initialItems.add(itemToBeRenewed);
                    initialItems.remove(itemToBeRenewed);
                }

            }

            input = scanner.nextLine();
        }

        String joined = String.join(", ", initialItems);
        System.out.println(joined);
    }
}
