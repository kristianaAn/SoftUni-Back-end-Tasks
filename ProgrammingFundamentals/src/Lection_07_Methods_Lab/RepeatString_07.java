package Lection_07_Methods_Lab;

import java.util.Scanner;

public class RepeatString_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(getNewInput(input, n));

    }
    public static String getNewInput (String input, int iterations) {
        String output = "";
        for (int i = 1; i <= iterations; i++) {
            output += String.join(" ", input);
        }
        return output;
    }
}
