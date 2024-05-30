/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OBS;

/**
 *
 * @author Balqis
 */
public class Signup {
    private String username;
    private String email;
    private String password;
    private String phoneNumber;

    public Signup(String username, String email, String password, String phoneNumber) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    

     }

    public boolean isValidEmail() {
        return email.contains("@");
    }

    public boolean isValidPassword() {
        return password.length() >= 5;
    }

    public Customer signup(Database database) {
        return new Customer(username, password, email, phoneNumber, 0);
    }

    
}