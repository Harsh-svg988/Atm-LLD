public class CardReader {
    public String inject() {
        System.out.println("Card Inserted.");
        return "12345"; // simulate card number
    }

    public boolean validate(BankServer bankServer, String cardNumber, String pin) {
        return bankServer.validateCard(cardNumber, pin);
    }

    public void eject() {
        System.out.println("Card Ejected.");
    }
}
