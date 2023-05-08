package BasicSyntax_MoreExercise;

import java.util.Scanner;

public class GamingStore_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double currentBalance = Double.parseDouble(scanner.nextLine());
        double initialMoney = currentBalance;
        String input = scanner.nextLine();
        double moneySpent = 0;

        while (!input.equals("Game Time")) {
            String gameName = input;
            double price = 0;

            switch (gameName) {
                case "OutFall 4":
                case "RoverWatch Origins Edition":
                    price = 39.99;
                    if (price > currentBalance) {
                        System.out.println("Too Expensive");
                        input = scanner.nextLine();
                        continue;
                    }
                    currentBalance -= price;
                    moneySpent += price;
                    System.out.printf("Bought %s%n", gameName);
                    break;
                case "CS: OG":
                    price = 15.99;
                    if (price > currentBalance) {
                        System.out.println("Too Expensive");
                        input = scanner.nextLine();
                        continue;
                    }
                    currentBalance -= price;
                    moneySpent += price;
                    System.out.printf("Bought %s%n", gameName);
                    break;
                case "Zplinter Zell":
                    price = 19.99;
                    if (price > currentBalance) {
                        System.out.println("Too Expensive");
                        input = scanner.nextLine();
                        continue;
                    }
                    currentBalance -= price;
                    moneySpent += price;
                    System.out.printf("Bought %s%n", gameName);
                    break;
                case "Honored 2":
                    price = 59.99;
                    if (price > currentBalance) {
                        System.out.println("Too Expensive");
                        input = scanner.nextLine();
                        continue;
                    }
                    currentBalance -= price;
                    moneySpent += price;
                    System.out.printf("Bought %s%n", gameName);
                    break;
                case "RoverWatch":
                    price = 29.99;
                    if (price > currentBalance) {
                        System.out.println("Too Expensive");
                        input = scanner.nextLine();
                        continue;
                    }
                    currentBalance -= price;
                    moneySpent += price;
                    System.out.printf("Bought %s%n", gameName);
                    break;
                default:
                    System.out.println("Not found");
                    break;
            }
            if (currentBalance == 0) {
                System.out.println("Out of money!");
                return;
            }

            input = scanner.nextLine();
        }
        if (currentBalance > 0) {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", moneySpent, initialMoney - moneySpent);
        }

    }
}
