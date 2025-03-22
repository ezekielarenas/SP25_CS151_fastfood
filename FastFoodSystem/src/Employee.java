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
            throw new IllegalStateException("Max # of employees is 100. Creation failed.");
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
            System.out.println(name + " has clocked in for " + hours + " hour(s). Total hours worked: " + hoursWorked);
        }
    }

    public void processOrder(Customer customer, CashRegister register, double amount) {
        if (customer == null || register == null) {
            System.out.println("Error: Customer or register is null.");
            return;
        }
        if (customer.processPayment(amount)) {
            System.out.println("Order processed successfully.");
        } else {
            System.out.println("Order processing failed.");
        }
    }

    public void issueRefund(Customer customer, CashRegister register, double amount) {
        if (customer == null || register == null) {
            System.out.println("Error: Customer or register is null.");
            return;
        }
        customer.issueRefund(amount);
        System.out.println("Refund issued successfully.");
    }

    public void restockItem(Inventory inventory, MenuItem item, int quantity) {
        if (inventory == null || item == null) {
            System.out.println("Error: Inventory or item is null.");
            return;
        }
        inventory.addItem(item, quantity);
        System.out.println("Item restocked successfully.");
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
