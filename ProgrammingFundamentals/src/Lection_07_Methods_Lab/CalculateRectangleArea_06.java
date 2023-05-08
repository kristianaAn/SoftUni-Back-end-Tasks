package Lection_07_Methods_Lab;

import java.util.Scanner;

public class CalculateRectangleArea_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());

        System.out.printf("%.0f",getRectangleArea(width, length));

    }
    public static double getRectangleArea (int width, int length) {
        return width * length;
    }
}
