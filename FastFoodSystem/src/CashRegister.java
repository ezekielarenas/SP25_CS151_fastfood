public class CashRegister implements Payable{
    
    private boolean inUse;
    private static double totalSales;
    private int id;
    private static final int MAX_REGISTERS = 100;
    private static int objectCount = 0;
    
    public CashRegister(int id) {
        if(objectCount >= MAX_REGISTERS) {
            throw new IllegalStateException("Max # of registers is 100. Creation failed.");
        }
        this.inUse = false;
        this.id = id;
        objectCount++;
    }

    public void displayRegisterStats() {
        System.out.printf("ID: %d | In Use: %s\n",
        this.id,
        this.inUse ? "Yes" : "No"
        );
    }

    //Will be used when customer orders food
    @Override
    public boolean processPayment(double amount) {
        totalSales += amount;
        return true;
    }

    @Override
    public void issueRefund(double amount) {
        totalSales -= amount;
        if(totalSales < amount) {
            System.out.println("Total sales are in the negatives, uh oh");
        }
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }

    public boolean getInUse() {
        return inUse;
    }

    public int getId() {
        return id;
    }
}
