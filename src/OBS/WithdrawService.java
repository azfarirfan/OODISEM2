package OBS;

public class WithdrawService extends BalanceService {

    public WithdrawService(Database database) {
        super(database);
    }

    @Override
    public void updateBalance(Customer customer, double amount) {
        customer.setBalance(customer.getBalance() - amount);
        System.out.println("\nCurrent balance after withdrawal: RM" + customer.getBalance());
    }

    public boolean withdrawFunds(Customer customer, double amount) {
        if (customer.getBalance() >= amount) {
            System.out.println("\nWithdrawal successful!");
            updateBalance(customer, amount);
            return true; // Withdrawal successful
        } else {
            return false; // Insufficient balance for withdrawal
        }
    }
}
