public interface Payable {
    boolean processPayment(double amount);
    void issueRefund(double amount);
}
