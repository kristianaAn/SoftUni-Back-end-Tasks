package Lection_06_Arrays_Exercise;

import java.util.Scanner;

public class ZigZagArrays_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        String[] newArray1 = new String[n];
        String[] newArray2 = new String[n];

        for (int rows = 1; rows <= n; rows++) {
            String[] array1 = scanner.nextLine().split(" ");
            String num1 = array1[0];
            String num2 = array1[1];
            if (rows % 2 == 0) {
                // четен ред: 1во число -> втори масив; 2ро число -> 1ви масив
                newArray2[rows - 1] = num1;
                newArray1[rows - 1] = num2;
            } else {
                // нечетен ред: 1во число -> първи масив; 2ро -> 2ри масив
                newArray1[rows - 1] = num1;
                newArray2[rows - 1] = num2;
            }
        }
        for (String number : newArray1) {
            System.out.print(number + " ");
        }
        System.out.println();
        for (String numbers : newArray2) {
            System.out.print(numbers + " ");
        }
    }
}
