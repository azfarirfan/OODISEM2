package OBS;

import java.util.Scanner;

public class OBSMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Database database = new Database();
        LoanService loanService = new LoanService();
        AccountService accountService = new AccountService();

        while (true) {
            System.out.println("\n``Welcome to the Online Banking System``");
            System.out.println("\n1. Login\n2. Signup\n3. Exit\n");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                // Simulate login process
                System.out.print("\nEnter username: ");
                String username = scanner.next();

                Customer customer = database.getCustomerByUsername(username);
                if (customer != null) {
                    System.out.print("Enter password: ");
                    String password = scanner.next();

                    AuthenticationService authService = new AuthenticationService(customer);

                    if (authService.authenticate(customer, password)) {
                        System.out.println("\nLogin successful!");

                        while (true) {
                            System.out.println("\nChoose an option:");
                            System.out.println("1. Transfer Funds\n2. Make Bill Payment\n3. Withdraw Funds\n4. Pay Deposit\n5. Apply for Loan\n6. Exit");
                            System.out.print("\nEnter choice: ");
                            int actionChoice = scanner.nextInt();

                            if (actionChoice == 1) {
                                // Transfer funds
                                Customer sender = database.getCustomerByUsername(username);
                                Customer recipient = database.getCustomerByUsername(username);

                                if (sender != null && recipient != null) {
                                    TransferService transferFunds = new TransferService(database, sender, recipient);

                                    // Prompt for transfer type
                                    System.out.println("\n1. Transfer to own account\n2. Transfer to another account");
                                    System.out.print("\nEnter choice: ");
                                    int transferChoice = scanner.nextInt();

                                    if (transferChoice == 1) {
                                        // Transfer to own account
                                        System.out.print("Enter transfer amount: RM");
                                        double amount = scanner.nextDouble();
                                        transferFunds.initiateTransferToOwnAccount(amount);
                                    } else if (transferChoice == 2) {
                                        // Transfer to another account
                                        while (true) {
                                            System.out.print("Enter recipient's username: ");
                                            String recipientUsername = scanner.next();
                                            recipient = database.getCustomerByUsername(recipientUsername);

                                            if (recipient != null) {
                                                System.out.print("\nEnter transfer amount: RM");
                                                double amount = scanner.nextDouble();
                                                transferFunds.initiateTransferToOtherAccount(recipient, amount);
                                                break;
                                            } else {
                                                System.out.println("\nRecipient not found in database. Please try again.");
                                            }
                                        }
                                    } else {
                                        System.out.println("\nInvalid choice.");
                                    }
                                } else {
                                    System.out.println("\nSender or recipient not found in database.");
                                }
                            } else if (actionChoice == 2) {
                                // Bill Payment
                                Customer currentCustomer = database.getCustomerByUsername(username);
                                BillService billManager = new BillService(database, currentCustomer);
                                scanner.nextLine(); // Consume newline character

                                while (true) {
                                    System.out.println("\nBill Payment System");
                                    System.out.println("1. Add Bill\n2. Pay Bill\n3. List Bills\n4. Exit");
                                    System.out.print("\nChoose an option: ");
                                    int billChoice = scanner.nextInt();
                                    scanner.nextLine(); // Consume newline character

                                    switch (billChoice) {
                                        case 1:
                                            System.out.print("Enter bill description: [A for electric] [B for monthly internet] [C for Loan] ");
                                            String description = scanner.nextLine();
                                            System.out.print("Enter bill amount: ");
                                            double billAmount = scanner.nextDouble();
                                            scanner.nextLine(); // Consume newline character
                                            billManager.addBill(new Bill(description, billAmount));
                                            break;
                                        case 2:
                                            System.out.print("Enter bill description to pay: ");
                                            String descToPay = scanner.nextLine();
                                            billManager.payBill(descToPay);
                                            break;
                                        case 3:
                                            billManager.listBills();
                                            break;
                                        case 4:
                                            System.out.println("Exiting bill payment system...");
                                            break;
                                        default:
                                            System.out.println("Invalid option. Please try again.");
                                    }

                                    if (billChoice == 4) {
                                        break; // Exit the bill payment system loop
                                    }
                                }

                            } else if (actionChoice == 3) {
                                // Withdraw funds
                                WithdrawService withdrawPage = new WithdrawService(database);
                                boolean successfulWithdrawal = false;

                                while (!successfulWithdrawal) {
                                    System.out.print("\nEnter withdrawal amount: RM");
                                    double withdrawalAmount = scanner.nextDouble();
                                    scanner.nextLine(); // Consume newline character

                                    if (withdrawPage.withdrawFunds(customer, withdrawalAmount)) {
                                        successfulWithdrawal = true;
                                    } else {
                                        System.out.println("\nInsufficient balance for withdrawal. Please enter a valid amount.");
                                    }
                                }
                            } else if (actionChoice == 4) {
                                // Deposit
                                System.out.print("Enter your username: ");
                                String accountNumberDeposit = scanner.next();
                                Customer currentCustomer = database.getCustomerByUsername(username);
                                if (currentCustomer != null) {
                                    System.out.print("Enter your password: ");
                                    String passwordDeposit = scanner.next();
                                    if (authService.authenticate(currentCustomer, passwordDeposit)) {
                                        System.out.print("Enter deposit amount: ");
                                        double depositAmount = scanner.nextDouble();
                                        accountService.deposit(currentCustomer, depositAmount);
                                    } else {
                                        System.out.println("Authentication failed!");
                                    }
                                } else {
                                    System.out.println("Customer not found!");
                                }
                            } else if (actionChoice == 5) {
                                // Apply for Loan
                                System.out.print("Enter your salary: RM");
                                double salary = scanner.nextDouble();
                                if (salary < 2500) {
                                    System.out.println("Your salary must be at least RM2500 to apply for a loan.");
                                    continue; // Return to the previous menu
                                }
                                System.out.println("Select the type of loan:");
                                System.out.println("1. Car Loan");
                                System.out.println("2. Personal Loan");
                                System.out.println("3. Home Loan");
                                System.out.print("Enter your choice (1-3): ");
                                int loanChoice = scanner.nextInt();

                                LoanType loanType;
                                switch (loanChoice) {
                                    case 1:
                                        loanType = LoanType.CAR_LOAN;
                                        break;
                                    case 2:
                                        loanType = LoanType.PERSONAL_LOAN;
                                        break;
                                    case 3:
                                        loanType = LoanType.HOME_LOAN;
                                        break;
                                    default:
                                        System.out.println("Invalid choice! Please select a valid loan type.");
                                        continue; // Continue to the next iteration of the loop
                                }

                                System.out.print("Enter loan amount: RM");
                                double loanAmount = scanner.nextDouble();
                                System.out.println("Loan application submitted successfully!");

                            } else if (actionChoice == 6) {
                                // Exit
                                System.out.println("Logging out...");
                                break; // Exit the action loop and return to login/register page
                            } else {
                                System.out.println("Invalid choice.");
                            }
                        }
                    } else {
                        System.out.println("Invalid password.");
                        System.out.print("Forgot password? (yes/no): ");
                        String forgotPasswordOption = scanner.next();
                        if (forgotPasswordOption.equalsIgnoreCase("yes")) {
                            System.out.print("Enter your email: ");
                            String forgotEmail = scanner.next();
                            ForgotPassword forgotPassword = new ForgotPassword(customer);
                            if (forgotPassword.verifyEmail(forgotEmail)) {
                                System.out.print("Enter your new password: ");
                                String newPassword = scanner.next();
                                forgotPassword.resetPassword(newPassword);
                                System.out.println("\nPassword reset successfully.");
                            } else {
                                System.out.println("\nEmail does not match our records.");
                            }
                        }
                    }
                } else {
                    System.out.println("Invalid username. Please try again.");
                }
            } else if (choice == 2) {
                System.out.print("Enter username: ");
                scanner.nextLine();
                String newUsername = scanner.nextLine();
                System.out.print("Enter phone number: ");
                String phoneNumber = scanner.nextLine();
                String email;
                while (true) {
                    System.out.print("Enter email: ");
                    email = scanner.nextLine();
                    if (email.contains("@")) {
                        break;
                    } else {
                        System.out.println("Invalid email format. Please enter a valid email.");
                    }
                }

                String newPassword;
                while (true) {
                    System.out.print("Enter password: ");
                    newPassword = scanner.nextLine();
                    if (newPassword.length() >= 5) {
                        break;
                    } else {
                        System.out.println("Your password is too short. Please enter a password with at least 5 characters.");
                    }
                }

                Signup signup = new Signup(newUsername, email, newPassword, phoneNumber);
                Customer newCustomer = signup.signup(database);
                database.addCustomer(newCustomer);

                System.out.println("Signup successful!");
            } 
            else if (choice == 3) {
                // Exit
                System.out.println("\nThank you for using our service. Have a great day!");
                System.out.println("Exiting...");
                scanner.close();
                System.exit(0);
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }
}
