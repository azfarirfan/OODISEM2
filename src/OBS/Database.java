/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OBS;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Balqis
 */
public class Database {
    private List<Customer> customers = new ArrayList<>();

    public Database() {
        // Initialize the database with some sample data
        customers.add(new Customer("azfar", "12345", "azfar@gmail.com", "0123456789", 1000.0));
        customers.add(new Customer("balqis", "12345", "balqis@gmail.com", "0123456789", 39000.0));
        customers.add(new Customer("fatin", "12345", "fatin@gmail.com", "0123456789", 2000.0));
        customers.add(new Customer("aliff", "12345", "aliff@gmail.com", "0123456789", 1500.0));
    }

    public Customer getCustomerByUsername(String username) {
        for (Customer customer : customers) {
            if (customer.getUsername().equals(username)) {
                return customer;
            }
        }
        return null; // Customer not found
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

}
