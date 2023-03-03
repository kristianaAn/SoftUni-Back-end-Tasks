package lection_14_Generics_Exercise.box.GenericBox;

import lection_14_Generics_Exercise.box.Box;

import java.util.Scanner;

public class Main_GenericBox_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Box<String> box = new Box<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            box.add(input);
        }

        System.out.println(box);
    }
}
