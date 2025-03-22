import java.util.HashMap;
import java.util.Map;

import menu.*;

public class Inventory implements Reportable{
    private Map<MenuItem, Integer> stock = new HashMap<>();

    public boolean isAvailable(MenuItem item, int quantity) {
        return stock.getOrDefault(item, 0) >= quantity;
    }

    public void addItem(MenuItem item, int quantity) {
        if (item == null || quantity <= 0) {
            System.out.println("Error: Invalid item or quantity.");
            return;
        }
        stock.put(item, stock.getOrDefault(item, 0) + quantity);
        System.out.println("Added " + quantity + " of " + item.getName() + " to inventory.");
    }

    public boolean reduceStock(MenuItem item, int quantity) {
        if (item == null || quantity <= 0) {
            System.out.println("Error: Invalid item or quantity.");
            return false;
        }
        if (isAvailable(item, quantity)) {
            stock.put(item, stock.get(item) - quantity);
            System.out.println("Reduced " + quantity + " of " + item.getName() + " from inventory.");
            return true;
        }
        System.out.println("Error: Not enough stock for " + item.getName());
        return false;
    }

    public void restock(MenuItem item, int quantity) {
        if (item == null || quantity <= 0) {
            System.out.println("Error: Invalid item or quantity.");
            return;
        }
        addItem(item, quantity);
        System.out.println("Restocked " + quantity + " of " + item.getName() + ".");
    }

    public void checkStock() {
        if (stock.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        System.out.println("Current Inventory:");
        for (Map.Entry<MenuItem, Integer> entry : stock.entrySet()) {
            System.out.println(entry.getKey().getName() + ": " + entry.getValue());
        }
    }

    @Override
    public void generateReport() {
        System.out.println("Inventory Report:");
        checkStock();
    }

    // Additional method to remove an item completely from inventory
    public void removeItem(MenuItem item) {
        if (item == null) {
            System.out.println("Error: Item is null.");
            return;
        }
        if (stock.containsKey(item)) {
            stock.remove(item);
            System.out.println("Removed " + item.getName() + " from inventory.");
        } else {
            System.out.println("Error: Item not found in inventory.");
        }
    }
}
