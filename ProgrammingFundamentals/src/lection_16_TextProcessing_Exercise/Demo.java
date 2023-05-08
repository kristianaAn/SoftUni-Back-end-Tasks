package lection_16_TextProcessing_Exercise;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        String res = "";

        char firstOccur = input.charAt(0);
        res += firstOccur;

        for (int i = 1; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);
            if (currentSymbol != firstOccur) {
                res += currentSymbol;
                firstOccur = currentSymbol;
            }

        }

        System.out.println(res);
    }
}
