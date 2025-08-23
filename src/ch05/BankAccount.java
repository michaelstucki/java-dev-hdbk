package ch05;

public class BankAccount {
    private double balance;

    public void deposit(double amount) throws BalanceException {
        if (amount <= 0) throw new BalanceException("Non-positive deposit");
        balance += amount;
    }

    public void withdraw(double amount) throws BalanceException {
        if (amount > balance) throw new BalanceException("Withdrawal exceeds balance");
        if (amount <= 0) throw new BalanceException("Non-position withdrawal");
        balance -= amount;
    }

    public double getBalance() { return balance; }
}
