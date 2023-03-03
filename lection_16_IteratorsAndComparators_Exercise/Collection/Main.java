package lection_16_IteratorsAndComparators_Exercise.Collection;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        ListyIterator listyIterator = null;

        while (!command.equals("END")) {
            if (command.contains("Create")) {
                String[] inputs = command.split("\\s+");
                String[] newInputs = Arrays.copyOfRange(inputs, 1, inputs.length);

                listyIterator = new ListyIterator("Create", newInputs);

            } else if ("Move".equals(command)) {
                System.out.println(listyIterator.move());
            } else if ("Print".equals(command)) {
                try {
                    listyIterator.print();
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                }
            } else if ("HasNext".equals(command)) {
                System.out.println(listyIterator.hasNext());
            } else if ("PrintAll".equals(command)) {
                try {
                    listyIterator.printAll();
                } catch (IllegalStateException n) {
                    System.out.println(n.getMessage());
                }

            }

            command = scanner.nextLine();
        }
    }
}
