package lection_14_Generics_Exercise.box.GenericCountMethodString;

import lection_14_Generics_Exercise.box.Box;

import java.util.Scanner;

public class GenericCountMethodString_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Box<String> box = new Box<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            box.add(input);
        }

        String comparableString = scanner.nextLine();

        System.out.println(box.greaterThan(comparableString));
    }
}
