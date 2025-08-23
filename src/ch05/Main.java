package ch05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create account
        BankAccount account = new BankAccount();

        // Manage account
        System.out.println("Bank Account Management");
        int option;
        double amount;
        do {
            option = getOption(sc);
            switch (option) {
                case 1: // deposit
                    amount = getAmount(sc);
                    try {
                        if (amount <= 0) throw new BalanceException("Non-positive amount");
                        account.deposit(amount);
                    } catch (BalanceException e) {
                        System.out.println(e.getMessage());;
                    }
                    break;
                case 2: // withdrawal
                    amount = getAmount(sc);
                    try {
                        if (amount <= 0) throw new BalanceException("Non-positive amount");
                        if (amount > account.getBalance()) throw new BalanceException("Amount exceeds balance");
                        account.withdraw(amount);
                    } catch (BalanceException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3: // get balance
                    System.out.println("Balance: " + account.getBalance());
                    break;
                case 4: // exit
                    continue;
                default:
                    System.out.println("Enter a number between 1 and 4");
            }
        } while(option != 4);
    }

    private static int getOption(Scanner sc) {
        String menu = "1. Deposit\n2. Withdrawal\n3. Show Balance\n4. Exit";
        boolean validOption = false;
        int option = 0;
        do {
            System.out.println(menu);
            System.out.print("Enter option: ");
            try {
                option = Integer.parseInt(sc.nextLine());
                validOption = true;
            } catch (NumberFormatException e) {
                System.out.println("Non-integer entered");
            }
        } while (!validOption);
        return option;
    }

    private static double getAmount(Scanner sc) {
        double amount = 0;
        boolean validAmount = false;
        do {
            System.out.print("Enter amount: ");
            try {
                amount = Double.parseDouble(sc.nextLine());
                validAmount = true;
            } catch (NumberFormatException e) {
                System.out.println("Non-double entered");
            }
        } while (!validAmount);
        return amount;
    }
}
