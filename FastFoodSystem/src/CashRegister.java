import java.util.ArrayList;

public class CashRegister implements Payable{
    
    private static ArrayList<CashRegister> registers;

    private boolean inUse;
    private double cashBalance; //Each register has its own balance being tracked

    public CashRegister(double cashBalance) {
        this.inUse = false;
        this.cashBalance = cashBalance;
        registers.add(this);
    }

    //If a customer wants to use a cash register, this function will be used to assign a cash register to that customer
    public CashRegister getRegister(int id) {
        return registers.get(id);
    }

    //Will be used when customer orders food
    public void processPayment(double amount) {
        
    }

    public void issueRefund(double amount) {

    }

}
