public class Customer extends Person implements Payable{
    
    private CashRegister registerToUse;
    private double balance;
    private boolean isWaitingOnOrder; 
    private Order currentOrder;
    private static final int MAX_CUSTOMERS = 100;
    private static int objectCount = 0;

    public Customer(int id, String name, boolean isWorking, double balance) {
        super(name, isWorking, id);
        if(objectCount >= MAX_CUSTOMERS) {
            throw new IllegalStateException("Max # of customers is 100. Creation failed.");
        }
        this.balance = balance;
        this.isWaitingOnOrder = false;
        objectCount++;
    }

    //Customer can choose a register to use. Once in use, no other customer can use that register until the customer has placed an order
    public void useRegister(CashRegister register) {
        if(register == null) {
            System.out.println("No register exists");
        } else if (registerToUse != null) {
            System.out.println("Error: Use the register you're already at");
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

    @Override
    public void displayInfo() {
        String registerInfo = (registerToUse != null) ? "Yes (Register " + registerToUse.getId() + ")" : "No";
        System.out.printf("ID: %d | Name: %s | Balance: $%.2f | Waiting on Order: %s | At Register: %s\n",
            this.id,
            this.getName(),
            this.balance,
            this.isWaitingOnOrder ? "Yes" : "No",
            registerInfo
        );
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
        this.isWaitingOnOrder = false;
    }

    public CashRegister getRegister() {
        return registerToUse;
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public void setCurrentOrder(Order order) {
        this.currentOrder = order;
    }

    // Getter and setter for isWaitingOnOrder
    public boolean isWaitingOnOrder() {
        return isWaitingOnOrder;
    }

    public void setWaitingOnOrder(boolean waitingOnOrder) {
        this.isWaitingOnOrder = waitingOnOrder;
    }

    
}
