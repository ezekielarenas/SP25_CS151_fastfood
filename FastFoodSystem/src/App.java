import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\n***********Fast Food Operation Simulation***********");
        System.out.println(
            "Type 'MENU' to return to menu or 'QUIT' to exit application\n" + 
            "1. Setup a cash register\n" +
            "2. Have a customer enter the store\n" +
            "3. Have a customer use a register to order" + //Once the order is done, an employee will be assigned to a customer. If there is no employee, the operation fails.
            "4. Have an employee clock in\n" + //User will be asked to enter employee details
            "5. Have an employee serve a customer\n" + //If inventory stock is insufficient, the operation fails
            "6. View inventory\n" + 
            "7. View employees\n" +
            "8. View registers\n" +
            "9. View current orders\n" +
            "10. Restock inventory" 
        );

        while(scanner.next() != "QUIT") {
            
        }

        System.out.println("Exiting...");
    }
}
