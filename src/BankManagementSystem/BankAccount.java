package BankManagementSystem;

public class BankAccount {
    private static double balance = 10000;

    public static void deposit(double amount) {
        balance += amount;
    }

    public static void withdraw(double amount) {
        balance -= amount;
    }

    public static double getBalance() {
        return balance;
    }
}
