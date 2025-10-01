public class DispenserValidationState implements WithdrawalState {
    @Override
    public void handle(WithdrawalContext context) {
        if (!context.getDispenser().canDispense(context.getAmount())) {
            System.out.println("ATM Dispenser has insufficient funds.");
            context.setSuccess(false);
            context.setState(null);
            return;
        }
        context.setState(new BalanceValidationState());
    }
}

