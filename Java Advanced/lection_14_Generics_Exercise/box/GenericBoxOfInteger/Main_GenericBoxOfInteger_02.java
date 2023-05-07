package lection_14_Generics_Exercise.box.GenericBoxOfInteger;

import lection_14_Generics_Exercise.box.Box;

import java.util.Scanner;

public class Main_GenericBoxOfInteger_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Box<Integer> box = new Box<>();

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(scanner.nextLine());
            box.add(input);
        }

        System.out.println(box);
    }
}
