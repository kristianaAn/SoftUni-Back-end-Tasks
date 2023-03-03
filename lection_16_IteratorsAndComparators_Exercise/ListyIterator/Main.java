package lection_16_IteratorsAndComparators_Exercise.ListyIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        firstListyIterator listyIterator = null;

        while (!command.equals("END")) {
            if (command.contains("Create")) {
                String[] inputs = command.split("\\s+");
                String[] newInputs = Arrays.copyOfRange(inputs, 1, inputs.length);

                listyIterator = new firstListyIterator("Create", newInputs);

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
            }

            command = scanner.nextLine();
        }
    }
}
