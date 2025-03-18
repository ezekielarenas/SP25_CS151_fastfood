import java.util.ArrayList;
import java.util.List;

public class Order implements Reportable {
    private int orderId;
    private Customer customer;
    private List<MenuItem> items;
    private double amountPaid;

    //Associate an order with a customer, assign order ID, initialize items list and amountPaid.
    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = new ArrayList<>();
        this.amountPaid = 0.0;
    }

    // Add MenuItem to customer order.
    public void addItem(MenuItem item) {
        items.add(item);
    }

    // Calculate the total cost of the order (needs getPrice() method in MenuItem).
    public double calculateTotal() {
        double total = 0.0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    // Record payment amount for customer order.
    public void processPayment(double amount) {
        this.amountPaid = amount;
    }

    // Sample idea for reportable interface
    @Override
    public void generateReport() {
        System.out.println("----- Order Report -----");
        System.out.println("Order ID: " + orderId);
        // Can't do until Customer class has getname method or something
        System.out.println("Customer: " + customer.getName()); 

        System.out.println("Items Ordered:");
        for (MenuItem item : items) {
            System.out.println("- " + item.getName() + " ($" + item.getPrice() + ")");
        }
        System.out.println("Calculated Total: $" + calculateTotal());
        System.out.println("Amount Paid: $" + amountPaid);
        System.out.println("------------------------");
    }
}