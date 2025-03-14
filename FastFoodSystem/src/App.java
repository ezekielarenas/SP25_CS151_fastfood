import java.util.HashMap;
import java.util.Scanner;

public class App {

    private static Scanner scanner = new Scanner(System.in);

    //Centralized user input so that program can quit whenever
    //
    public static String getInput(String message) {
        System.out.println(message);
        String input = scanner.nextLine();

        if(input.equals("QUIT")) {
            System.out.println("Exiting...");
            scanner.close();
            System.exit(0);
        }

        return input;
    }

    public static void printMenu() {
        System.out.println(
            "\nType 'MENU' to return to menu or 'QUIT' to exit application\n" + 
            "1. Setup a cash register\n" +
            "2. Have a customer enter the store\n" + //(Creating a customer object)
            "3. Have a customer go to a register\n" + //A customer must be at a register before being able to order
            "4. Have customer order\n" + //Once the order is done, an employee will be assigned to a customer. If there is no employee, the operation fails.
            "5. Have an employee clock in\n" + //User will be asked to enter employee details (Creating an employee object)
            "6. Have an employee serve a customer\n" + //If inventory stock is insufficient, the operation fails
            "7. View inventory\n" + 
            "8. View employees\n" +
            "9. View registers\n" +
            "10. View current orders\n" +
            "11. Restock inventory" 
        );
    }

    public static void main(String[] args) throws Exception {

        System.out.println("\n\n***********Fast Food Operation Simulation***********");
        printMenu();

        HashMap<Integer, Customer> customerList = new HashMap<>();
        HashMap<Integer, CashRegister> registerList = new HashMap<>();


        while(true) {
            String input = getInput("");
            switch(input) {
                //Have static methods in each class for having user input create objects
                case "1":
                    int registerId = Integer.valueOf(getInput("Give this register an id"));
                    if(registerList.containsKey(registerId)) {
                        System.out.println("Error: Duplicate ID");
                        break;
                    }

                    registerList.put(registerId, new CashRegister());
                    break;
                case "2":
                    int customerID = Integer.valueOf(getInput("Enter customer ID: "));
                    if(customerList.containsKey(customerID)) {
                        System.out.println("Error: Duplicate ID");
                        break;
                    }
                    String customerName = getInput("Enter customer name: ");
                    double customerBalance = Double.parseDouble(getInput("What is this customer's balance?: "));

                    customerList.put(customerID, new Customer(customerID, customerName, false, customerBalance));
                    break;
                case "3":
                    int selectedCustomerID = Integer.valueOf(getInput("Which customer will use a register?"));
                    if(customerList.containsKey(selectedCustomerID)) {
                        int registerToBeUsedID = Integer.valueOf(getInput("Which register will " + customerList.get(selectedCustomerID).name + " use?:"));
                        customerList.get(selectedCustomerID).useRegister(registerList.get(registerToBeUsedID));
                    } else {
                        System.out.println("Error: Invalid ID");
                    }
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    break;
                case "7":
                    break;
                case "8":
                    break;
                case "9":
                    break;
                case "10":
                    break;
                case "11":
                    break;
                default:
                    System.out.println("Invalid input");
                    break;

            }
            printMenu();
        }
    }
}
