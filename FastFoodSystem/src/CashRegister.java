public class CashRegister implements Payable{
    
    private boolean inUse;
    private static double totalSales;
    
    public CashRegister() {
        this.inUse = false;
    }

    //Will be used when customer orders food
    public boolean processPayment(double amount) {
        totalSales += amount;
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
