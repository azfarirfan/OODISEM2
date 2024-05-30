/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OBS;

/**
 *
 * @author Balqis
 */

public class Customer {
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private double loanAmount;
    private double savingBalance;
    protected double balance;

    public Customer(String username, String password, String email, String phoneNumber, double balance) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.loanAmount = 0;
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public boolean hasSufficientFunds(double amount) {
        return balance >= amount;
    }

    public void deductBalance(double amount) {
        if (hasSufficientFunds(amount)) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds to deduct the amount.");
        }
    }
    
    public void transferToSaving(double amount) {
        savingBalance += amount;
        System.out.println("Saving Account Balance: RM" + savingBalance);
    }

    public void deposit(double amount) {
        if (amount < balance) {
            balance -= amount;
            System.out.println("Deposit successful. New balance: RM" + balance);
        } else {
            System.out.println("\nInvalid deposit amount.");
            System.out.println("Current balance: " + balance);
        }
    }
    
    public void applyForLoan(double amount) {
        if (amount < balance) {
            loanAmount += amount;
            System.out.println("Loan application successful. New balance: " + balance);
        } else {
            System.out.println("\nInvalid loan amount.");
            System.out.println("Current balance: " + balance);
        }
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    void setUsername(String username) {
        this.username = username;
    }

    int getSalary() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void loan(double amount) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
