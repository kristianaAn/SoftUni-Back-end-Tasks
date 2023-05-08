package Lection_02_BasicSyntax_Exercise;

import java.util.Scanner;

public class VendingMachine_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        double sumCoins = 0;
        while (!input.equals("Start")) {
            double insertedCoin = Double.parseDouble(input);
            if (insertedCoin == 0.1 || insertedCoin == 0.2 || insertedCoin == 0.5 || insertedCoin == 1 || insertedCoin == 2) {
                sumCoins += insertedCoin;
            } else {
                System.out.printf("Cannot accept %.2f%n", insertedCoin);
            }
            input = scanner.nextLine();
        }

        double totalCurrentPrice = 0;
        String productsInput = scanner.nextLine();
        while (!productsInput.equals("End")) {
            switch (productsInput) {
                case "Nuts":
                    totalCurrentPrice += 2;
                    if (totalCurrentPrice > sumCoins) {
                        totalCurrentPrice -= 2;
                        System.out.println("Sorry, not enough money");
                    } else {
                        System.out.printf("Purchased %s%n", productsInput);
                    }
                    break;
                case "Water":
                    totalCurrentPrice += 0.7;
                    if (totalCurrentPrice > sumCoins) {
                        totalCurrentPrice -= 0.7;
                        System.out.println("Sorry, not enough money");
                    } else {
                        System.out.printf("Purchased %s%n", productsInput);
                    }
                    break;
                case "Crisps":
                    totalCurrentPrice += 1.5;
                    if (totalCurrentPrice > sumCoins) {
                        totalCurrentPrice -= 1.5;
                        System.out.println("Sorry, not enough money");
                    } else {
                        System.out.printf("Purchased %s%n", productsInput);
                    }
                    break;
                case "Soda":
                    totalCurrentPrice += 0.8;
                    if (totalCurrentPrice > sumCoins) {
                        totalCurrentPrice -= 0.8;
                        System.out.println("Sorry, not enough money");
                    } else {
                        System.out.printf("Purchased %s%n", productsInput);
                    }
                    break;
                case "Coke":
                    totalCurrentPrice++;
                    if (totalCurrentPrice > sumCoins) {
                        totalCurrentPrice--;
                        System.out.println("Sorry, not enough money");
                    } else {
                        System.out.printf("Purchased %s%n", productsInput);
                    }
                    break;
                default:
                    System.out.println("Invalid product");
            }
            productsInput = scanner.nextLine();
        }
        System.out.printf("Change: %.2f", Math.abs(sumCoins - totalCurrentPrice));
    }
}
