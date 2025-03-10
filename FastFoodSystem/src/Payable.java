public interface Payable {
    void processPayment(double amount);
    void issueRefund(double amount);
}
