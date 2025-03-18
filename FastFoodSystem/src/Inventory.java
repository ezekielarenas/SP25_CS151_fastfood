import java.util.HashMap;
import java.util.Map;


public class Inventory implements Reportable{
    private Map<MenuItem, Integer> stock = new HashMap<>();

    public boolean isAvailable(MenuItem item, int quantity) {
        return stock.getOrDefault(item, 0) >= quantity;
    }

    public void addItem(MenuItem item, int quantity) {
        stock.put(item, stock.getOrDefault(item, 0) + quantity);
    }

    public boolean reduceStock(MenuItem item, int quantity) {
        if (isAvailable(item, quantity)) {
            stock.put(item, stock.get(item) - quantity);
            return true;
        }
        return false;
    }

    public void restock(MenuItem item, int quantity) {

    }

    public void checkStock() {
        
    }

    @Override
    public void generateReport() {

    }
}
