public class CashRegister implements Payable{
    
    private boolean inUse;
    private double amountInRegister;

    public CashRegister() {
        this.inUse = false;
        amountInRegister = 500;
    }

    //Will be used when customer orders food
    public boolean processPayment(double amount) {
        amountInRegister += amount;
        return true;
    }

    public void issueRefund(double amount) {

    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }

    public boolean getInUse() {
        return inUse;
    }

}
