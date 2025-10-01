public class BalanceValidationState implements WithdrawalState {
    @Override
    public void handle(WithdrawalContext context) {
        if (!context.getBankServer().hasSufficientBalance(context.getCardNumber(), context.getAmount())) {
            System.out.println("Insufficient account balance.");
            context.setSuccess(false);
            context.setState(null);
            return;
        }
        context.setState(new DailyLimitValidationState());
    }
}

