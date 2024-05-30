package OBS;

public abstract class BalanceService {
    protected Database database;
    

    public BalanceService(Database database) {
        this.database = database;
    }

    public abstract void updateBalance(Customer customer, double amount);
}
