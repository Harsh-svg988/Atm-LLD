public class DispenseCashState implements WithdrawalState {
    @Override
    public void handle(WithdrawalContext context) {
        context.getDispenser().dispense(context.getAmount());
        context.getBankServer().debitAccount(context.getCardNumber(), context.getAmount());
        System.out.println("Withdrawal successful: " + context.getAmount());
        context.setSuccess(true);
        context.setState(null); // End
    }
}

