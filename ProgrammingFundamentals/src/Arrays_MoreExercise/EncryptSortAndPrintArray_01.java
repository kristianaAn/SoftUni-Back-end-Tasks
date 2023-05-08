package Arrays_MoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortAndPrintArray_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] names = new String[n];

        for (int i = 0; i <= names.length - 1; i++) {
            String name = scanner.nextLine();
            names[i] = name + " = " + summedLetters(name);
        }

        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
    }

    public static int summedLetters(String name) {
        int sum = 0;

        for (int i = 0; i < name.length(); i++) {
            char symbol = name.charAt(i);
            if (symbol == 'a' || symbol == 'e' || symbol == 'i' || symbol == 'o' || symbol == 'u') {
                sum += (int) symbol * name.length();
            } else {
                sum += (int) symbol / name.length();
            }
        }
        return sum;
    }
}
