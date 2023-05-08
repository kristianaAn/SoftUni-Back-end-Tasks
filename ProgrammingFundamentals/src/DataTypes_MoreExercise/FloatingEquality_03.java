package DataTypes_MoreExercise;

import java.util.Scanner;

public class FloatingEquality_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double firstNum = Double.parseDouble(scanner.nextLine());
        double secondNum = Double.parseDouble(scanner.nextLine());
        double eps = 0.000001;

        if (firstNum > secondNum) {
            if (firstNum - secondNum <= eps) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        } else if (firstNum < secondNum) {
            if (secondNum - firstNum <= eps) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        }
    }
}
