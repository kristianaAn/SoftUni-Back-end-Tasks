package Lection_05_Arrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseAnArrayOfStrings_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] elements = scanner.nextLine().split(" ");
        int iterations = elements.length / 2;

        for (int i = 0; i < iterations; i++) {
            String firstEl = elements[i];
            String lastEl = elements[elements.length - 1 - i];
            elements[i] = lastEl;
            elements[elements.length - 1 - i] = firstEl;
        }

        for (String el : elements) {
            System.out.print(el + " ");
        }
    }
}
