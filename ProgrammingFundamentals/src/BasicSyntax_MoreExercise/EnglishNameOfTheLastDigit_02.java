package BasicSyntax_MoreExercise;

import java.util.Scanner;

public class EnglishNameOfTheLastDigit_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        String[] englishNames = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        int lastDigit = num % 10;

        for (int i = 0; i <= 9; i++) {
            if (i == lastDigit) {
                System.out.println(englishNames[i]);
            }
        }
    }
}
