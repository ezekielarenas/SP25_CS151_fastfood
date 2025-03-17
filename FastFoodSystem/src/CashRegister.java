public class CashRegister implements Payable{
    
    private boolean inUse;

    public CashRegister() {
        this.inUse = false;
    }

    //Will be used when customer orders food
    public void processPayment(double amount) {

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
