public class Customer extends Person implements Payable{
    
    CashRegister registerToUse;
    double balance;

    public Customer(int id, String name, boolean isWorking, double balance) {
        super(name, isWorking, id);
        this.balance = balance;
    }

    //Customer can choose a register to use. Once in use, no other customer can use that register until the customer has placed an order
    public void useRegister(CashRegister register) {
        if(!register.getInUse()) {
            register.setInUse(true);
            this.registerToUse = register;
        } else {
            System.out.println("Error: Register is already in use");
        }
    }

    public void displayInfo() {
        
    }

    //When customer orders food
    public void processPayment(double amount) {
        
    }

    public void issueRefund(double amount) {

    }
}
