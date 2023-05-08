package Lection_09_Lists_Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> inputNums = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();
        String command = "";

        while (!input.equals("end")) {
            command = input.split(" ")[0];

            switch (command) {
                case "Add":
                    int numberToAdd = Integer.parseInt(input.split(" ")[1]);
                    inputNums.add(numberToAdd);
                    break;
                case "Remove":
                    int numberToRemove = Integer.parseInt(input.split(" ")[1]);
                    inputNums.remove(Integer.valueOf(numberToRemove));
                    break;
                case "RemoveAt":
                    int indexToRemove = Integer.parseInt(input.split(" ")[1]);
                    inputNums.remove(indexToRemove);
                    break;
                case "Insert":
                    int number = Integer.parseInt(input.split(" ")[1]);
                    int index = Integer.parseInt(input.split(" ")[2]);
                    inputNums.add(index, number);
                    break;
            }

            input = scanner.nextLine();
        }

        for (int num : inputNums) {
            System.out.print(num + " ");
        }
    }
}
