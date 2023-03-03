package lection_14_Generics_Exercise.box.GenericSwapMethodInteger;

import lection_14_Generics_Exercise.box.Box;

import java.util.Scanner;

public class Main_GenericSwapMethodInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Box<Integer> box = new Box<>();

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(scanner.nextLine());
            box.add(input);
        }

        String[] swapIndices = scanner.nextLine().split("\\s+");
        int firstIndex = Integer.parseInt(swapIndices[0]);
        int secondIndex = Integer.parseInt(swapIndices[1]);

        box.swap(firstIndex, secondIndex);

        System.out.println(box);
    }
}
