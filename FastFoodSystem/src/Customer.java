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

    public void placeOrder(Order order) {

        if(registerToUse != null) {
            //Once order is placed, register is freed to be used whether the transaction worked or not
            registerToUse.setInUse(false); 
            registerToUse = null;
            if(processPayment(order.calculateTotal())) {
                this.isWaitingOnOrder = true;
            } 
        } else {
            System.out.println("Couldn't place order, customer is not at a register");;
        }
    }

    public void displayInfo() {
        
    }

    //When customer orders food
    public boolean processPayment(double amount) {
        if(balance < amount) {
            System.out.println("Insufficient balance.");
            return false;
        }
        balance -= amount;
        return true;
    }

    public void issueRefund(double amount) {

    }
}
