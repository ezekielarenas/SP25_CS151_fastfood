public class Customer extends Person implements Payable{
    
    CashRegister registerToUse;

    public Customer(int id, String name, boolean isWorking, String position, double payRate, int hoursWorked) {
        super(name, isWorking, id);
    }

    //Customer can choose a register to use. Once in use, no other customer can use that register until the customer has placed an order
    public void useRegister(int registerNumber) {
        this.registerToUse = CashRegister.useRegister(registerNumber);
    }

    public void displayInfo() {

    }

    //When customer orders food
    public void processPayment(double amount) {
        
    }

    public void issueRefund(double amount) {

    }
}
