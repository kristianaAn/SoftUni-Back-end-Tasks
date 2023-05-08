package MidExam;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Numbers_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Finish")) {
            String command = input.split(" ")[0];

            if (command.equals("Add")) {
                int valueToAdd = Integer.parseInt(input.split(" ")[1]);
                numbers.add(valueToAdd);
            } else if (command.equals("Remove")) {
                int valueToRemove = Integer.parseInt(input.split(" ")[1]);
                numbers.remove(Integer.valueOf(valueToRemove));
            } else if (command.equals("Replace")) {
                int valueToFind = Integer.parseInt(input.split(" ")[1]);
                int valueToReplaceWith = Integer.parseInt(input.split(" ")[2]);
                for (int i = 0; i <= numbers.size() - 1; i++) {
                    if (numbers.get(i) == valueToFind) {
                        numbers.set(i, valueToReplaceWith);
                        break;
                    }
                }
            } else if (command.equals("Collapse")) {
                int value = Integer.parseInt(input.split(" ")[1]);
                for (int i = 0; i <= numbers.size() - 1; i++) {
                    int currentNum = numbers.get(i);
                    if (currentNum < value) {
                        numbers.remove(numbers.get(i));
                        i--;
                    }
                }
            }

            input = scanner.nextLine();
        }
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}
