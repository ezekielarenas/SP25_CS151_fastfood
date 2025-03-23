# Fast Food Operation Simulation

An emulation of a fast food restaurant where customers, employees, and cash registers interact, simulated by an object-oriented program. 

## Design

The program is made up of these classes:
- Customer: Class that represents customer with properties like ID, name, balance, current order, and register it is using. Can place orders and receive refunds. 
- Employee: Represents employee with ID, name, position, payrate, and hours worked. Can clock in and out, manage inventory, and process orders.
- CashRegister: Tracks its own usage state and handles payments and refunds. Each register has a unique ID.
- Order:
- Menu Items: Superclass of classes Burger, Fry, and Milkshake, with prices assigned to each one.
- Inventory: Manages the stock of menu items and supports restocking and stock checks
- Payable interface: Payable interface created for entities that process payments or refunds
- Reportable interface:
- App: The main class with the main method, responsible for running the simulation and handling user input.

Design considerations:
- Centralized user input using custom `getInput()` so that user can type 'quit' no matter where they in the program
- Used HashMap for customers, registers, and employees for uniqueness and fast look up and searching of objects
- Real world flow simulated by `Customer -> CashRegister -> Order` 

## Installation Instructions

```bash
git clone https://github.com/ezekielarenas/SP25_CS151_fastfood.git 
cd SP25_CS151_fastfood/FastFoodSystem/src
javac App.java
java App
```

## Usage

- To select entities, you have to use their IDs

1. **Set up cash registers**
    - Choose option 1 to create and give a unique ID to register
    - Registers are required before customers can place orders

2. **Add customers to system**
    - Choose option 2 to create a customer, giving it a unique ID, name, and starting balance

3. **Have a customer go to a register**
    - Choose option 3 to assign a customer to an available register so they can place an order
    - A customer can't use a register that is in use by another customer

4. **Place order**
    - Choose option 4 to have a customer who is at a register place an order, where they can select items from a menu by entering 1-3
    - Once order is placed, register will become free and Customer's status will be waiting for their order
    - If a customer already has an order and goes to a register to make another one, they will be prompted to refund their original order
        - They will still be at the register until refunding is done

5. **Have employee serve customer**
    - Choose option 5 to have an employee fulfill a customer's order. The employee checks inventory stock and processes the order

6. **Have a customer refund**
    - Choose option 6 to have a customer who is waiting on their order to refund
    - Customer must be at a register to do a refund
    - Once refund is done, register will become free

7. **Display entries of Customers and Registers**
    - Choose option 7 to display table of customers and registers and their properties
    - Displays states: Whether register is in use, customer is at a register(and which register), and if a customer is waiting on an order

8. **Check Stock**
    - Choose option 8 to have an employee check the current inventory stock levels

9. **Restock Invetory**
    - Choose option 9 to have an employee restock a specific menu item in the inventory.

10. **Employee clock-in**
    - Choose option 10 to have an employee clock in for their shift, specifying the number of hours worked.

11. **Employee clock-out**
    - Choose option 11 to have an employee clock out, updating their total hours worked.
    
12. **Pay Employee**
    - Choose option 12 to retrieve an employee's paycheck. The employee must have clocked out before receiving their paycheck.

## Contributions

- Jason Palomino
    - Implemented Customer and Cash Register class.
    - Implemented interaction between Customer and Registers in main method.

- Ezekiel Arenas
    - Implemented the Employee and Inventory classes.
    - Added functionalities for employees to serve customers, restock inventory, and manage their working hours.