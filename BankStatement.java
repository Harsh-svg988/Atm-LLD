public class BankStatement extends Transactions {
    private String cardNumber;

    public BankStatement(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean makeTransaction(BankServer bankServer) {
        System.out.println("Printing Bank Statement for " + cardNumber);
        return true;
    }
}
