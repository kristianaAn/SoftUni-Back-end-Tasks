package MidExamPreparation;

import java.util.Scanner;

public class ComputerStore_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        double sumWithoutTax = 0;
        double taxSum = 0;
        double totalSumWithTaxes = 0;
        double currentProductTotalPrice = 0;
        while (!input.equals("special") && !input.equals("regular")) {
            double partPrice = Double.parseDouble(input);
            if (partPrice < 0) {
                System.out.println("Invalid price!");
                input = scanner.nextLine();
                continue;
            }
            sumWithoutTax = sumWithoutTax + partPrice;
            taxSum = taxSum + (partPrice * 0.2);
            currentProductTotalPrice = partPrice + (partPrice * 0.2);
            totalSumWithTaxes = totalSumWithTaxes + currentProductTotalPrice;

            input = scanner.nextLine();
        }
        if (totalSumWithTaxes == 0) {
            System.out.println("Invalid order!");
            return;
        }
        if (input.equals("special")) {
            double totalPriceAfterDiscount = totalSumWithTaxes * 0.90;
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", sumWithoutTax);
            System.out.printf("Taxes: %.2f$%n", taxSum);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$", totalPriceAfterDiscount);
        } else if (input.equals("regular")){
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", sumWithoutTax);
            System.out.printf("Taxes: %.2f$%n", taxSum);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$", totalSumWithTaxes);
        }
    }
}
