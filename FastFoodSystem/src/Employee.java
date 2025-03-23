import menu.MenuItem;

public class Employee extends Person{
    private String position;
    private double payRate;
    private int hoursWorked;
    private static final int MAX_HOURS_PER_DAY = 8;


    private static final int MAX_EMPLOYEES = 100;
    private static int objectCount = 0;

    // Constructor
    public Employee(int id, String name, boolean isWorking, String position, double payRate, int hoursWorked) {
        super(name, isWorking, id);
        if(objectCount >= MAX_EMPLOYEES) {
            throw new IllegalStateException("Max # of employees is 100.");
        }
        this.position = position;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
        objectCount++;
    }

    public double calculateSalary() {
        return payRate * hoursWorked;
    }

    public void clockIn(int hours) {
        if (hours <= 0) {
            System.out.println("Invalid hours. Please enter a positive number.");
            return;
        }
        if (hours > MAX_HOURS_PER_DAY) {
            System.out.println("Error: Cannot work more than " + MAX_HOURS_PER_DAY + " hours in a day.");
        } else {
            hoursWorked += hours;
            this.setWorking(true);
            System.out.println(name + " has clocked in for " + hours + " hour(s). Total hours worked: " + hoursWorked);
        }
    }

    public void clockOut() {
        this.setWorking(false);
        System.out.println(name + " has clocked out.");
    }

    public void processOrder(Customer customer, Inventory inventory) {
        // Check if order is valid
        Order order = customer.getCurrentOrder();
        if (order == null) {
            System.out.println("Error: No order found.");
            return;
        }
        if (customer == null || inventory == null) {
            System.out.println("Error: Unavailable inventory or customer.");
            return;
        }
        if (!customer.isWaitingOnOrder()) {
            System.out.println("Error: Customer hasn't order.");
        } 
        
        
        // Check stock
        for (MenuItem item : order.getItems()) { 
            if (!inventory.isAvailable(item, 1)) {
                System.out.println("Error: Insufficient stock.");
                return;
            }
        }

        // Reduce stock for each item in the order
        for (MenuItem item: order.getItems()) {
            inventory.reduceStock(item, 1);
        }

        customer.setWaitingOnOrder(false);
        customer.setCurrentOrder(null);
        System.out.println("Order fulfilled succesfully. Thank you! ");
    
    }

    public void restockItem(Inventory inventory, MenuItem item, int quantity) {
        if (inventory == null || item == null) {
            System.out.println("Error: Inventory or item is null.");
            return;
        }
        inventory.addItem(item, quantity);
        System.out.println("Item restocked successfully.");
    }

    public void checkStock(Inventory inventory) {
        if (inventory == null) {
            System.out.println("Error: Inventory is null.");
            return;
        }
        inventory.checkStock();
    }

    public void resetHoursWorked() {
        hoursWorked = 0;
        System.out.println("Hours worked reset to 0.");
    }

    @Override
    public void displayInfo() {
        System.out.println("Name: " + name + "\nEmployeeID: " + id + "\nPosition: " + position + "\nHours Worked: " + hoursWorked + "\nSalary: $" + calculateSalary());
    }

    

}
