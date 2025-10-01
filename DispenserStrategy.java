import java.util.HashMap;

public interface DispenserStrategy {
    boolean dispenseAmount(int amount, HashMap<Integer, Integer> cashInventory);
}

