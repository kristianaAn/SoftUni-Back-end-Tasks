package methods_MoreExercise;

import java.util.Scanner;

public class DataTypes_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputType = scanner.nextLine();
        String input = scanner.nextLine();

        printFormattedOutput(inputType, input);
    }
    public static void printFormattedOutput (String inputType, String input) {
        if (inputType.equals("int")) {
            int num = Integer.parseInt(input);
            System.out.println(num * 2);
        } else if (inputType.equals("real")) {
            double num = Double.parseDouble(input);
            System.out.printf("%.2f", num * 1.5);
        } else if (inputType.equals("string")) {
            System.out.printf("$%s$", input);
        }
    }
}
