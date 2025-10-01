public class AtmController {
    private CardReader cardReader;
    private Dispenser dispenser;
    private Keyboard keyboard;
    private Printer printer;
    private Screen screen;
    private BankServer bankServer;

    private String activeCard;

    public AtmController(CardReader cardReader, Dispenser dispenser,
                         Keyboard keyboard, Printer printer,
                         Screen screen, BankServer bankServer) {
        this.cardReader = cardReader;
        this.dispenser = dispenser;
        this.keyboard = keyboard;
        this.printer = printer;
        this.screen = screen;
        this.bankServer = bankServer;
    }

    public void startSession() {
        screen.displayMessage("Please insert your card...");
        activeCard = cardReader.inject();
    }

    public boolean validateCard() {
        screen.displayMessage("Enter PIN:");
        String pin = keyboard.getPin();

        if (cardReader.validate(bankServer, activeCard, pin)) {
            screen.displayMessage("Card validated successfully!");
            return true;
        } else {
            screen.displayError("Invalid Card or PIN.");
            return false;
        }
    }

    public void executeTransaction() {
        int choice = keyboard.selectTransaction();
        Transactions transaction;

        switch (choice) {
            case 1: // Withdraw
                screen.displayMessage("Enter amount to withdraw:");
                int amount = Integer.parseInt(keyboard.getInput());
                transaction = new Withdraw(amount, dispenser);
                break;
            case 2: // Check Balance
                transaction = new CheckBalance(activeCard);
                break;
            case 3: // Bank Statement
                transaction = new BankStatement(activeCard);
                break;
            default:
                screen.displayError("Invalid selection.");
                return;
        }

        boolean success = transaction.makeTransaction(bankServer);
        if (success) {
            printer.printTransactionDetails();
        } else {
            printer.printError();
        }
    }

    public void endSession() {
        cardReader.eject();
        screen.displayMessage("Thank you for using ATM!");
    }
}
