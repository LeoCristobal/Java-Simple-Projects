package BankManagementSystem;

public class Customer implements Runnable {
    private final String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public synchronized void run() {
        System.out.println("Customer " + name + " is running...");
        System.out.println("Customer " + name + " is depositing...");
        BankAccount.deposit(100);
        pause(500);

        System.out.println("Customer " + name + " is withdrawing...");
        BankAccount.withdraw(50);
        pause(500);

        System.out.println("Customer " + name + " is depositing...");
        BankAccount.deposit(300);
        pause(500);

        System.out.println("Customer " + name + " is withdrawing...");
        BankAccount.withdraw(200);
        pause(500);


    }

    public void pause(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
