public class WithdrawalContext {
    private WithdrawalState state;
    private int amount;
    private String cardNumber;
    private Dispenser dispenser;
    private BankServer bankServer;
    private boolean success;

    public WithdrawalContext(int amount, String cardNumber, Dispenser dispenser, BankServer bankServer) {
        this.amount = amount;
        this.cardNumber = cardNumber;
        this.dispenser = dispenser;
        this.bankServer = bankServer;
        this.success = false;
        this.state = new AmountValidationState(); // First state
    }

    public void setState(WithdrawalState state) {
        this.state = state;
    }

    public void process() {
        while (state != null) {
            state.handle(this);
        }
    }

    // Getters
    public int getAmount() { return amount; }
    public String getCardNumber() { return cardNumber; }
    public Dispenser getDispenser() { return dispenser; }
    public BankServer getBankServer() { return bankServer; }

    // Status
    public void setSuccess(boolean success) { this.success = success; }
    public boolean isSuccess() { return success; }
}
