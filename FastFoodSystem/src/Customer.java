public class Customer extends Person implements Payable{
    
    private CashRegister registerToUse;
    private double balance;
    private boolean isWaitingOnOrder; 

    public Customer(int id, String name, boolean isWorking, double balance) {
        super(name, isWorking, id);
        this.balance = balance;
        this.isWaitingOnOrder = false;
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

    public void placeOrder() {
        if(registerToUse != null) {
            this.isWaitingOnOrder = true;
        } else {
            System.out.println("Couldn't place order, customer is not at a register");;
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
