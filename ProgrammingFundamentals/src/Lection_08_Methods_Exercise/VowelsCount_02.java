package Lection_08_Methods_Exercise;

import java.util.Scanner;

public class VowelsCount_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();
        // vowels: 'a', 'e', 'o', 'u', 'i'

        printVowelsCount(input);

    }

    public static void printVowelsCount(String text) {
        int vowelsCount = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == 'a' || text.charAt(i) == 'e' || text.charAt(i) == 'o'
                    || text.charAt(i) == 'u' || text.charAt(i) == 'i') {
                vowelsCount++;
            }
        }
        System.out.println(vowelsCount);
    }
}
