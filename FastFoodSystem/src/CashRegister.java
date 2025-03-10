import java.util.ArrayList;

public class CashRegister implements Payable{
    
    private static ArrayList<CashRegister> registers;

    private boolean inUse;
    private double cashBalance; //Each register has its own balance being tracked
    private int registerID;

    public CashRegister(int id, double cashBalance) {
        this.registerID = id;
        this.inUse = false;
        this.cashBalance = cashBalance;
        registers.add(this);
    }

    //Searches for the register based on ID and returns it to the Customer. The returned register will be assigned to the Customer
    //State of inUse changed to prervent other customers from using it while Customer is preparing to place order
    public static CashRegister useRegister(int id) {
        for(CashRegister register : registers) {
            if(id == register.registerID && !register.inUse) {
                register.inUse = true;
                return register;
            }
        }
        return null; 
    }

    //Will be used when customer orders food
    public void processPayment(double amount) {

    }

    public void issueRefund(double amount) {

    }

}
