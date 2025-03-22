public class Employee extends Person{
    private String position;
    private double payRate;
    private int hoursWorked;

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

    // Abastract method
    @Override
    public void displayInfo() {
        System.out.println("Name: " + name + "\nEmployeeID: " + id + "\nPosition: " + position);
    }

    public double calculateSalary() {
        return payRate * hoursWorked;
    }

    
}
