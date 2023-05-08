package Lection_06_Arrays_Exercise;

import java.util.Scanner;

public class Train_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int [] wagonsArr = new int[n];

        int sum = 0;
        for (int i = 0; i < wagonsArr.length; i++) {
            wagonsArr[i] = Integer.parseInt(scanner.nextLine());
        }

        for (int i = 0; i < wagonsArr.length; i++) {
            sum += wagonsArr[i];
            System.out.print(wagonsArr[i] + " ");
        }
        System.out.println();
        System.out.println(sum);
    }
}
