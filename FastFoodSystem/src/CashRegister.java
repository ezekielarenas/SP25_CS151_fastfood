import java.util.ArrayList;

public class CashRegister implements Payable{
    
    private static ArrayList<CashRegister> registers;

    private boolean inUse;

    public CashRegister(int id, double cashBalance) {
        this.inUse = false;
        registers.add(this);
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
