package lection_11_DefiningClasses_lab_BankAccount_03;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<Integer, BankAccount> accounts = new HashMap<>();


        while (!input.equals("End")) {
            String outputToPrint = "";

            if (input.contains("Create")) {
               BankAccount bankAccount = new BankAccount();
               accounts.put(bankAccount.getId(), bankAccount);
               outputToPrint = String.format("Account ID%d created", bankAccount.getId());
                System.out.println(outputToPrint);
            } else if (input.contains("Deposit")) {
               //Deposit {Id} {Amount}
               int id = Integer.parseInt(input.split("\\s+")[1]);
               double amount = Double.parseDouble(input.split("\\s+")[2]);

               if (accounts.containsKey(id)) {
                   BankAccount currentBankAccount = accounts.get(id);
                   currentBankAccount.deposit(amount);
                   accounts.put(id, currentBankAccount);
                   outputToPrint = String.format("Deposited %.0f to ID%d", amount, currentBankAccount.getId());
                   System.out.println(outputToPrint);
               } else {
                   outputToPrint = "Account does not exist";
                   System.out.println(outputToPrint);
               }

            } else if (input.contains("GetInterest")) {
                //GetInterest {ID} {Years}
                int id = Integer.parseInt(input.split("\\s+")[1]);
                int years = Integer.parseInt(input.split("\\s+")[2]);

                if (accounts.containsKey(id)) {
                    BankAccount currentAccount = accounts.get(id);
                    outputToPrint = String.format("%.2f",  currentAccount.getInterest(years));
                    System.out.println(outputToPrint);
                } else {
                    outputToPrint = "Account does not exist";
                    System.out.println(outputToPrint);
                }

            } else if (input.contains("SetInterest")) {
               //SetInterest {Interest}
                double newInterest = Double.parseDouble(input.split("\\s+")[1]);

                BankAccount.setDefaultInterestRate(newInterest);
            }

            input = scanner.nextLine();
        }
    }
}
