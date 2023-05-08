package Lection_06_Arrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numsArray = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String command = scanner.nextLine();

        while (!command.equals("end")) {
            if (command.equals("decrease")) {
                for (int i = 0; i < numsArray.length; i++) {
                    numsArray[i]--;
                }
            } else {
                String[] commandParts = command.split(" ");
                String currentCommand = commandParts[0];
                int index1 = Integer.parseInt(commandParts[1]);
                int index2 = Integer.parseInt(commandParts[2]);

                if (currentCommand.equals("swap")) {
                    int firstCurrentNum = numsArray[index1];
                    int secondCurrentNum = numsArray[index2];
                    numsArray[index2] = firstCurrentNum;
                    numsArray[index1] = secondCurrentNum;
                } else if (currentCommand.equals("multiply")) {
                    int product = numsArray[index1] * numsArray[index2];
                    numsArray[index1] = product;
                }
            }
            command = scanner.nextLine();
        }
        for (int i = 0; i < numsArray.length; i++) {
            if (i != numsArray.length - 1) {
                System.out.print(numsArray[i] + ", ");
            } else {
                System.out.print(numsArray[i]);
            }
        }
    }
}
