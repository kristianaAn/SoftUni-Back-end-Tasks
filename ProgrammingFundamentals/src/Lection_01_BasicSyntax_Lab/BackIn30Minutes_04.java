package Lection_01_BasicSyntax_Lab;

import java.util.Scanner;

public class BackIn30Minutes_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hours = Integer.parseInt(scanner.nextLine());
        int mins = Integer.parseInt(scanner.nextLine());

        int totalTime = (hours * 60) + mins;
        int newTime = totalTime + 30;
        int newHour = newTime / 60;
        int newMins = newTime % 60;

        if (newHour > 23) {
            newHour = 0;
        }

        System.out.printf("%d:%02d", newHour, newMins);
    }
}
