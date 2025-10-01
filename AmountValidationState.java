public class AmountValidationState implements WithdrawalState {
    @Override
    public void handle(WithdrawalContext context) {
        int amount = context.getAmount();

        if (amount <= 0 || amount % 100 != 0) {
            System.out.println("Invalid amount. Must be multiple of 100.");
            context.setSuccess(false);
            context.setState(null); // End
            return;
        }
        context.setState(new DispenserValidationState());
    }
}

