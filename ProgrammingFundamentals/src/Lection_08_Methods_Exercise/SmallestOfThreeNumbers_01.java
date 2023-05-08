package Lection_08_Methods_Exercise;

import java.net.Inet4Address;
import java.util.Scanner;

public class SmallestOfThreeNumbers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number1 = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());
        int number3 = Integer.parseInt(scanner.nextLine());

        printMinNum(number1, number2, number3);

    }

    public static void printMinNum(int num1, int num2, int num3) {
        int minNum = 0;
        if (num1 < num2 && num1 < num3) {
            minNum = num1;
        } else if (num2 < num1 && num2 < num3) {
            minNum = num2;
        } else {
            minNum = num3;
        }
        System.out.println(minNum);
    }
}
