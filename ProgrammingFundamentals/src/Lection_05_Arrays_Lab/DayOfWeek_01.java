package Lection_05_Arrays_Lab;

import java.util.Scanner;

public class DayOfWeek_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String [] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        if (n >= 1 && n <= 7) {
            System.out.println(daysOfWeek[n - 1]);
        } else {
            System.out.println("Invalid day!");
        }
    }

}
