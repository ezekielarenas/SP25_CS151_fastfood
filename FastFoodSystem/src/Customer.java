public class Customer extends Person implements Payable{
    
    private CashRegister registerToUse;
    private double balance;
    private boolean isWaitingOnOrder; 
    private Order currentOrder;

    public Customer(int id, String name, boolean isWorking, double balance) {
        super(name, isWorking, id);
        this.balance = balance;
        this.isWaitingOnOrder = false;
    }

    //Customer can choose a register to use. Once in use, no other customer can use that register until the customer has placed an order
    public void useRegister(CashRegister register) {
        if(register == null) {
            System.out.println("No register exists");
        }
        else if(!register.getInUse()) {
            register.setInUse(true);
            this.registerToUse = register;
        } else {
            System.out.println("Error: Register is already in use");
        }
    }

    public void placeOrder(Order order) {

        if(processPayment(order.calculateTotal())) {
            currentOrder = order;
            this.isWaitingOnOrder = true;
            registerToUse.processPayment(order.calculateTotal());
            order.generateReport();
        } 
        //Once order is placed, register is freed to be used whether the transaction worked or not
        registerToUse.setInUse(false); 
        registerToUse = null;
    }

    public void displayInfo() {
        
    }

    @Override
    public boolean processPayment(double amount) {
        if(balance < amount) {
            System.out.println("Insufficient balance.");
            return false;
        }
        balance -= amount;
        registerToUse.processPayment(amount);
        return true;
    }

    @Override
    public void issueRefund(double amount) {
        System.out.println("Order refunded");
        balance += amount;
        registerToUse.issueRefund(amount);
        registerToUse.setInUse(false); 
        registerToUse = null;
        currentOrder = null;
    }

    public CashRegister getRegister() {
        return registerToUse;
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }
}
