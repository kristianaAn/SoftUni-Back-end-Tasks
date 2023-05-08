package Lection_07_Methods_Lab;

import java.util.Scanner;

public class Orders_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());

        switch (product) {
            case "coffee":
                printsCoffeeBill(quantity);
                break;
            case "water":
                printsWaterBill(quantity);
                break;
            case "coke":
                printsCokeBill(quantity);
                break;
            case "snacks":
                printsSnacksBill(quantity);
                break;
        }
    }

    public static void printsCoffeeBill(int qty) {
        double bill = 1.50 * qty;
        System.out.printf("%.2f",bill);
    }

    public static void printsWaterBill(int qty) {
        double bill = 1.00 * qty;
        System.out.printf("%.2f",bill);
    }

    public static void printsCokeBill(int qty) {
        double bill = 1.40 * qty;
        System.out.printf("%.2f",bill);
    }

    public static void printsSnacksBill(int qty) {
        double bill = 2.00 * qty;
        System.out.printf("%.2f",bill);
    }
}
