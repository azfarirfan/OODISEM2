/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package OBS;

/**
 *
 * @author Shafiniy
 */
public class ForgotPassword {
    private Customer customer;

    public ForgotPassword(Customer customer) {
        this.customer = customer;
    }

    public boolean verifyEmail(String enteredEmail) {
        return customer.getEmail().equals(enteredEmail);
    }

    public void resetPassword(String newPassword) {
        customer.setPassword(newPassword);
    }
}