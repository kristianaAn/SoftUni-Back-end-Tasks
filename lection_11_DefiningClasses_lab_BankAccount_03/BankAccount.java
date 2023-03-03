package lection_11_DefiningClasses_lab_BankAccount_03;

public class BankAccount {

    private int id;
    private static int counter = 0;
    private double balance;
    private static double defaultInterestRate = 0.02;

    public BankAccount() {
        counter++;
        this.id = counter;
        this.balance = 0;
    }

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public static void setDefaultInterestRate(double defaultInterestRate) {
        BankAccount.defaultInterestRate = defaultInterestRate;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public double getInterest(int years) {
        return defaultInterestRate * years * this.balance;
    }

    public double getBalance() {
        return balance;
    }

    public int getId() {
        return id;
    }
}
