package OBS;

public class TransferService extends BalanceService {
    private Customer sender;
    private Customer recipient;

    public TransferService(Database database, Customer sender, Customer recipient) {
        super(database);
        this.sender = sender;
        this.recipient = recipient;
    }

    @Override
    public void updateBalance(Customer customer, double amount) {
        customer.setBalance(customer.getBalance() - amount);
        System.out.println("\nCurrent balance after transfer: RM" + customer.getBalance());
    }

    public void initiateTransferToOwnAccount(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
            return;
        }

        if (amount > 2000) {
            System.out.println("Amount exceeds daily transfer limit of RM2000.");
            return;
        }

        if (sender.getBalance() >= amount) {
            System.out.println("\nTransfer successful!");
            updateBalance(sender, amount);
            recipient.transferToSaving(amount);
        } else {
            System.out.println("Insufficient balance for transfer.");
        }
    }

    public void initiateTransferToOtherAccount(Customer recipient, double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
            return;
        }

        if (amount > 2000) {
            System.out.println("Amount exceeds daily transfer limit of RM2000.");
            return;
        }

        if (sender.getBalance() >= amount) {
            System.out.println("\nTransfer successful!");
            updateBalance(sender, amount);
            recipient.setBalance(recipient.getBalance() + amount);
        } else {
            System.out.println("Insufficient balance for transfer.");
        }
    }
}
