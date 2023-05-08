package Lection_13_AssociativeArrays_lab;

import java.util.Arrays;
import java.util.Scanner;

public class WordFilter_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputWords = Arrays.stream(scanner.nextLine().split(" ")).filter(e -> e.length() % 2 == 0).toArray(String[]::new);

        for (String item : inputWords) {
            System.out.println(item);
        }
    }
}
