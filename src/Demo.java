import BankManagementSystem.BankAccount;
import BankManagementSystem.Customer;

class Demo {
    static void main(String[] args) throws InterruptedException {
        Customer customer1 = new Customer("A");
        Customer customer2 = new Customer("B");
        Customer customer3 = new Customer("C");

        Thread t1 = new Thread(customer1);
        Thread t2 = new Thread(customer2);
        Thread t3 = new Thread(customer3);

        System.out.println("=========================");
        System.out.println(" MULTI-THREADED BANK  ");
        System.out.println("=========================\n");
        System.out.printf("Initial balance: %.2f \n", BankAccount.getBalance());
        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.printf("Final balance: %.2f \n", BankAccount.getBalance());

    }
}