package lection_14_Generics_Exercise.box.GenericCountMethodDouble;

import lection_14_Generics_Exercise.box.Box;

import java.util.Scanner;

public class GenericCountMethodDouble_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Box<Double> box = new Box<>();

        for (int i = 0; i < n; i++) {
            double input = Double.parseDouble(scanner.nextLine());
            box.add(input);
        }

        double comparableString = Double.parseDouble(scanner.nextLine());

        System.out.println(box.greaterThan(comparableString));
    }
}
