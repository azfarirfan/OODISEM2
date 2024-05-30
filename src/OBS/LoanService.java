/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OBS;

/**
 *
 * @author Balqis
 */
public class LoanService {
    public void applyForLoan(Customer customer, double salary) {
        if (customer.getSalary() < 2500) {
            System.out.println("Your salary must be at least RM2500 to apply for a loan.");
        }
        
    }
}


