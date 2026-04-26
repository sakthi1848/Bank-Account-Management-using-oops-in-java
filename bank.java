import java.io.*;
import java.util.*;

abstract class BankAccount {

    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private String accountType;

    public BankAccount(String accountNumber, String accountHolderName, double balance, String accountType) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.accountType = accountType;
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);

    public double getBalance() {
        return balance;
    }

    public void addBalance(double amount) {
        balance = balance + amount;
    }

    public void subtractBalance(double amount) {
        balance = balance - amount;
    }

    public void displayAccountDetails() {
        System.out.println("Account Details:");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Account Type: " + accountType);
        System.out.printf("Balance: $%.1f\n", balance);
    }
}

class SavingsAccount extends BankAccount {

    public SavingsAccount(String accountNumber, String accountHolderName, double balance, String accountType) {
        super(accountNumber, accountHolderName, balance, accountType);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            addBalance(amount);
            System.out.printf("Deposit Successful. Updated Balance: $%.1f\n", getBalance());
        } else {
            System.out.println("Invalid Transaction");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= getBalance()) {
            subtractBalance(amount);
            System.out.printf("Withdrawal Successful. Updated Balance: $%.1f\n", getBalance());
        } else {
            System.out.println("Invalid Transaction");
        }
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the account number:");
        String accNo = sc.nextLine();

        System.out.println("Enter the account holder's name:");
        String name = sc.nextLine();

        System.out.println("Enter the initial balance:");
        double balance = sc.nextDouble();
        sc.nextLine();

        System.out.println("Enter the account type:");
        String type = sc.nextLine();

        BankAccount account = new SavingsAccount(accNo, name, balance, type);

        account.displayAccountDetails();

        System.out.println("Enter deposit amount:");
        double depositAmount = sc.nextDouble();
        account.deposit(depositAmount);

        System.out.println("Enter withdrawal amount:");
        double withdrawAmount = sc.nextDouble();
        account.withdraw(withdrawAmount);

        account.displayAccountDetails();

        sc.close();
    }
}