public class DailyLimitValidationState implements WithdrawalState {
    @Override
    public void handle(WithdrawalContext context) {
        if (!context.getBankServer().withinDailyLimit(context.getCardNumber(), context.getAmount())) {
            System.out.println("Daily withdrawal limit exceeded.");
            context.setSuccess(false);
            context.setState(null);
            return;
        }
        context.setState(new DispenseCashState());
    }
}

