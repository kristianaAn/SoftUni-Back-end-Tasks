package Lection_07_Methods_Lab;

import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.util.Scanner;

public class MathPower_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double number = Double.parseDouble(scanner.nextLine());
        int pow = Integer.parseInt(scanner.nextLine());
        DecimalFormat df = new DecimalFormat("0.####");

        System.out.println(df.format(numberAtPow(number,pow)));
    }
    public static double numberAtPow (double num, int pow) {
        double result = 1;
        for (int i = 1; i <= pow; i++) {
            result *= num;
        }
        return result;
    }
}
