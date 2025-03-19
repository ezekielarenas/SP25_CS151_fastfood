public class CashRegister implements Payable{
    
    private boolean inUse;

    public CashRegister() {
        this.inUse = false;
    }

    //Will be used when customer orders food
    public boolean processPayment(double amount) {
        return false;
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
