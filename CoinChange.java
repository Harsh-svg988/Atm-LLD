import java.util.*;

public class CoinChange implements DispenserStrategy {
    
    public boolean dispenseAmount(int amount, HashMap<Integer, Integer> cashInventory) {
        // simple greedy approach
        int remaining = amount;
        for (int denom : cashInventory.keySet()) {
            while (remaining >= denom && cashInventory.get(denom) > 0) {
                remaining -= denom;
                cashInventory.put(denom, cashInventory.get(denom) - 1);
            }
        }
        return remaining == 0;
    }

}
