package Lection_02_BasicSyntax_Exercise;

import java.util.Scanner;

public class Vacation_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int peopleCount = Integer.parseInt(scanner.nextLine());
        String groupType = scanner.nextLine();
        String weekday = scanner.nextLine();

        double price = 0;

        switch (groupType) {
            case "Students":
                switch (weekday) {
                    case "Friday":
                        price = peopleCount * 8.45;
                        break;
                    case "Saturday":
                        price = peopleCount * 9.80;
                        break;
                    case "Sunday":
                        price = peopleCount * 10.46;
                        break;
                }
                break;
            case "Business":
                switch (weekday) {
                    case "Friday":
                        if (peopleCount >= 100) {
                            price = (peopleCount - 10) * 10.90;
                        } else {
                            price = peopleCount * 10.90;
                        }
                        break;
                    case "Saturday":
                        if (peopleCount >= 100) {
                            price = (peopleCount - 10) * 15.60;
                        } else {
                            price = peopleCount * 15.60;
                        }
                        break;
                    case "Sunday":
                        if (peopleCount >= 100) {
                            price = (peopleCount - 10) * 16;
                        } else {
                            price = peopleCount * 16;
                        }
                        break;
                }
                break;
            case "Regular":
                switch (weekday) {
                    case "Friday":
                        price = peopleCount * 15;
                        break;
                    case "Saturday":
                        price = peopleCount * 20;
                        break;
                    case "Sunday":
                        price = peopleCount * 22.50;
                        break;
                }
                break;
        }
        if (groupType.equals("Students") && peopleCount >= 30) {
            price = price * 0.85;
        } else if (groupType.equals("Regular") && peopleCount >= 10 && peopleCount <= 20) {
            price = price * 0.95;
        }
        System.out.printf("Total price: %.2f", price);
    }
}
