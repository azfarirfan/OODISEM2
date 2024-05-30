/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OBS;

/**
 *
 * @author Balqis
 */
public class Bill {
    private String description;
    private double amount;
    private boolean isPaid;

    public Bill(String description, double amount) {
        this.description = description;
        this.amount = amount;
        this.isPaid = false;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void payBill() {
        if (!isPaid) {
            isPaid = true;
            System.out.println(description + " has been paid.");
        } else {
            System.out.println(description + " is already paid.");
        }
    }

    @Override
    public String toString() {
        return description + ": RM" + amount + " - " + (isPaid ? "Paid" : "Unpaid");
    }
}
