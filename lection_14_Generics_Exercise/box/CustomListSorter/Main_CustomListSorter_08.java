package lection_14_Generics_Exercise.box.CustomListSorter;

import java.util.Scanner;

public class Main_CustomListSorter_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputCommand = scanner.nextLine();
        CustomList<String> box = new CustomList<>();

        while (!inputCommand.equals("END")) {
            String command = inputCommand.split("\\s+")[0];

            switch (command) {
                case "Add":
                    String elementToAdd = inputCommand.split("\\s+")[1];
                    box.add(elementToAdd);
                    break;
                case "Remove":
                    int indexToRemove = Integer.parseInt(inputCommand.split("\\s+")[1]);
                    box.remove(indexToRemove);
                    break;
                case "Contains":
                    String element = inputCommand.split("\\s+")[1];
                    System.out.println(box.contains(element));
                    break;
                case "Swap":
                    int index1 = Integer.parseInt(inputCommand.split("\\s+")[1]);
                    int index2 = Integer.parseInt(inputCommand.split("\\s+")[2]);
                    box.swap(index1, index2);
                    break;
                case "Greater":
                    String elementToCount = inputCommand.split("\\s+")[1];
                    System.out.println(box.greaterThan(elementToCount));
                    break;
                case "Max":
                    System.out.println(box.getMax());
                    break;
                case "Min":
                    System.out.println(box.getMin());
                    break;
                case "Sort":
                    Sorter.sort(box);
                    break;
                case "Print":
                    System.out.print(box);
                    break;
            }

            inputCommand = scanner.nextLine();
        }
    }
}
