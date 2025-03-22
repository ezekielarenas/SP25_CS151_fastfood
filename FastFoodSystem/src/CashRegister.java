public class CashRegister implements Payable{
    
    private boolean inUse;
    private static double totalSales;
    private int id;
    
    public CashRegister(int id) {
        this.inUse = false;
        this.id = id;
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
