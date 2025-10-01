import java.util.HashMap;

public class Dispenser {
    private HashMap<Integer, Integer> cashInventory = new HashMap<>();
    private DispenserStrategy strategy;

    public Dispenser(DispenserStrategy strategy) {
        this.strategy = strategy;
        cashInventory.put(2000, 10);
        cashInventory.put(500, 20);
        cashInventory.put(100, 50);
    }

    public boolean cashAvailable(int amount) {
        return strategy.dispenseAmount(amount, cashInventory);
    }

    public void dispense(int amount) {
        if (cashAvailable(amount)) {
            System.out.println("Dispensing " + amount);
        } else {
            System.out.println("Insufficient Cash");
        }
    }

    public void reloadCash(int denomination, int count) {
        cashInventory.put(denomination, cashInventory.getOrDefault(denomination, 0) + count);
    }
}

