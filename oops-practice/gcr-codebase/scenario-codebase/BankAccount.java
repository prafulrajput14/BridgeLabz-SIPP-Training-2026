public class BankAccount {
    private String accountNumber;
    private String holder;
    private double balance;
    private static int totalAccounts = 0;

    public BankAccount(String accountNumber, String holder, double balance) {
        this.accountNumber = accountNumber;
        this.holder = holder;
        this.balance = balance;
        totalAccounts++;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + ". New balance: $" + balance);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew $" + amount + ". New balance: $" + balance);
        } else {
            System.out.println("Overdraft! Insufficient funds. Current balance: $" + balance);
        }
    }

    public void getStatement() {
        System.out.println("Account: " + accountNumber + " | Holder: " + holder + " | Balance: $" + balance);
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static void main(String[] args) {
        BankAccount a1 = new BankAccount("ACC001", "Alice", 1000);
        BankAccount a2 = new BankAccount("ACC002", "Bob", 500);
        BankAccount a3 = new BankAccount("ACC003", "Charlie", 2000);

        a1.deposit(200);
        a1.withdraw(150);
        a1.deposit(50);
        a1.withdraw(1300);
        a1.getStatement();

        a2.deposit(100);
        a2.withdraw(600);
        a2.deposit(300);
        a2.withdraw(200);
        a2.getStatement();

        a3.withdraw(500);
        a3.deposit(400);
        a3.withdraw(1000);
        a3.deposit(600);
        a3.getStatement();

        System.out.println("Total accounts created: " + BankAccount.getTotalAccounts());
    }
}
