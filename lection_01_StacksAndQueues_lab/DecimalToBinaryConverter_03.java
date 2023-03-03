package lection_01_StacksAndQueues_lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNum = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> binaryStack = new ArrayDeque<>();

        if (inputNum == 0) {
            System.out.println("0");
            return;
        }

        while (inputNum != 0) {
            binaryStack.push(inputNum % 2);
            inputNum = inputNum / 2;
        }

        for (Integer integer : binaryStack) {
            System.out.print(integer + "");
        }
    }
}
