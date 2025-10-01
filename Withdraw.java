
public class Withdraw extends Transactions {
    private int amount;
    private Dispenser dispenser;
    private String cardNumber;

    public Withdraw(int amount, Dispenser dispenser) {
        this.amount = amount;
        this.dispenser = dispenser;
        this.cardNumber = "12345";
    }

    @Override
    public boolean makeTransaction(BankServer bankServer) {
        WithdrawalContext context = new WithdrawalContext(amount, cardNumber, dispenser, bankServer);
        context.process();
        return context.isSuccess();
    }
}