
public class Withdraw extends Transactions {
    private int amount;
    private Dispenser dispenser;

    public Withdraw(int amount, Dispenser dispenser) {
        this.amount = amount;
        this.dispenser = dispenser;
    }

    @Override
    public boolean makeTransaction(BankServer bankServer) {
        if (bankServer.debitAccount("12345", amount)) {
            dispenser.dispense(amount);
            System.out.println("Withdrawal of " + amount + " successful.");
            return true;
        }
        return false;
    }
}