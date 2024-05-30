/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OBS;

/**
 *
 * @author Balqis
 */
public class AuthenticationService {
    private Customer customer;

    public AuthenticationService(Customer customer) {
        this.customer = customer;
    }
    
    public boolean authenticate(Customer customer, String enteredPassword) {
        return customer.getPassword().equals(enteredPassword);
    }
 
}