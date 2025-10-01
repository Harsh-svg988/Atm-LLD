import java.util.HashMap;

public class BankServer {
    private HashMap<String, Integer> accounts = new HashMap<>();
    private HashMap<String, String> pins = new HashMap<>();

    public BankServer() {
        // Dummy accounts setup
        accounts.put("12345", 5000);   // card number → balance
        accounts.put("67890", 10000);

        pins.put("12345", "1234"); // card → pin
        pins.put("67890", "2222");
    }

    public boolean validateCard(String cardNumber, String pin) {
        if (accounts.containsKey(cardNumber) && pins.get(cardNumber).equals(pin)) {
            System.out.println("BankServer: Card validated.");
            return true;
        }
        System.out.println("BankServer: Invalid card or PIN.");
        return false;
    }

    public int getBalance(String cardNumber) {
        return accounts.getOrDefault(cardNumber, 0);
    }

    public boolean debitAccount(String cardNumber, int amount) {
        if (accounts.containsKey(cardNumber) && accounts.get(cardNumber) >= amount) {
            accounts.put(cardNumber, accounts.get(cardNumber) - amount);
            System.out.println("BankServer: Debited " + amount + " from " + cardNumber);
            return true;
        }
        System.out.println("BankServer: Insufficient funds.");
        return false;
    }

    public void creditAccount(String cardNumber, int amount) {
        accounts.put(cardNumber, accounts.getOrDefault(cardNumber, 0) + amount);
        System.out.println("BankServer: Credited " + amount + " to " + cardNumber);
    }
}
