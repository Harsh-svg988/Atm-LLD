public class Main {
    public static void main(String[] args) {
        BankServer bankServer = new BankServer();

        AtmController atm = new AtmController(
                new CardReader(),
                new Dispenser(new CoinChange()),
                new PhysicalKeyboard(),
                new Printer(),
                new Screen(),
                bankServer
        );

        atm.startSession();

        if (atm.validateCard()) {
            atm.executeTransaction();
        }

        atm.endSession();
    }
}
