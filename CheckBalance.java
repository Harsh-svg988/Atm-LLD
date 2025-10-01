public class CheckBalance extends Transactions {
    private String cardNumber;

    public CheckBalance(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean makeTransaction(BankServer bankServer) {
        System.out.println("Balance: " + bankServer.getBalance(cardNumber));
        return true;
    }
}
