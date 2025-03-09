import java.util.ArrayList;

public class CashRegister {
    
    private static ArrayList<CashRegister> registers;
    private boolean inUse;

    public CashRegister() {
        inUse = false;
        registers.add(this);
    }

    public CashRegister getRegister(int id) {
        return registers.get(id);
    }

    




}
