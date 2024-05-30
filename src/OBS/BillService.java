package OBS;

import java.util.ArrayList;

public class BillService extends BalanceService {
    private ArrayList<Bill> bills;
    private Customer currentCustomer;

    public BillService(Database database, Customer currentCustomer) {
        super(database);
        this.bills = new ArrayList<>();
        this.currentCustomer = currentCustomer;
    }

    @Override
    public void updateBalance(Customer customer, double amount) {
        customer.setBalance(customer.getBalance() - amount);
        System.out.println("\nCurrent balance after pay bills: RM" + customer.getBalance());
    }

    public void addBill(Bill bill) {
        bills.add(bill);
        System.out.println("\n" + bill.getDescription() + " has been added.");
    }

    public void payBill(String description) {
        for (Bill bill : bills) {
            if (bill.getDescription().equalsIgnoreCase(description)) {
                if (currentCustomer.hasSufficientFunds(bill.getAmount())) {
                    bill.payBill();
                    updateBalance(currentCustomer, bill.getAmount());
                } else {
                    System.out.println("Not enough funds to pay " + description + ". Current balance: RM" + currentCustomer.getBalance());
                }
                return;
            }
        }
        System.out.println("Bill not found: (PLEASE CHECK YOUR CODE IN LIST BILL TY) " + description);
    }

    public void listBills() {
        for (Bill bill : bills) {
            System.out.println(bill);
        }
    }
}
