public class Employee extends Person{
    private String position;
    private double payRate;
    private int hoursWorked;

    // Constructor
    public Employee(int id, String name, boolean isWorking, String position, double payRate, int hoursWorked) {
        super(name, isWorking, id);
        this.position = position;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
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
