# SLogo API Design Lab Discussion
### NAMES: Kevin Deng (kd254@duke.edu), Spencer Katz (sek49@duke.edu), Doga Ozmen (odo4@duke.edu), Alisha Zhang (xz352@duke.edu)
### TEAM 4


## Planning Questions

 * What behaviors (methods) should the Turtle have and what service should it provide?
   * Drawing lines according to an input
   * change colors
   * change width of the line
   * change direction

 * When does parsing need to take place and what does it need to start properly?
   * when config receives a line of code

 * What is the result of parsing (not the details of the algorithm) and who receives it?
   * passing the instruction to turtle so that it can perform an action based on the code

 * When are errors detected and how are they reported?
   * user enters a command that doesn't exist; warning message (UI)

 * What do different commands need to know, when do they know it, and how do they get it?
   * parameters: direction, speed, color, line width, how much to move
   * after parsing
   * parser returns it to controller/view

 * What behaviors does the result of a command need to have to be used by the View?
   * descriptions of the parameters that do not give an error

 * How is the View updated after a command has completed execution?
   * 

 * What value would Controller(s) have in mediating between the Model and View?
 


## APIs
 
### Model/Backend External API

 * Goals
 
 * Contract
 
 * Services


### View/Frontend External API

 * Goals
 
 * Contract
 
 * Services



### Model/Backend Internal API

 * Goals
 
 * Contract
 
 * Services


### View/Frontend Internal API

 * Goals
 
 * Contract
 
 * Services



## Design

### Backend Design CRCs

This class's purpose or value is to represent a customer's order:
![Order Class CRC Card](order_crc_card.png "Order Class")

This class's purpose or value is to represent a customer's order:

|Order| |
|---|---|
|boolean isInStock(OrderLine)         |OrderLine|
|double getTotalPrice(OrderLine)      |Customer|
|boolean isValidPayment (Customer)    | |
|void deliverTo (OrderLine, Customer) | |

This class's purpose or value is to represent a customer's order:
```java
public class Order {
     // returns whether or not the given items are available to order
     public boolean isInStock (OrderLine items)
     // sums the price of all the given items
     public double getTotalPrice (OrderLine items)
     // returns whether or not the customer's payment is valid
     public boolean isValidPayment (Customer customer)
     // dispatches the items to be ordered to the customer's selected address
     public void deliverTo (OrderLine items, Customer customer)
 }
 ```

This class's purpose or value is to manage something:
```java
public class Something {
     // sums the numbers in the given data
     public int getTotal (Collection<Integer> data)
	 // creates an order from the given data
     public Order makeOrder (String structuredData)
 }
```


### Frontend Design CRCs


This class's purpose or value is to represent a customer's order:
![Order Class CRC Card](order_crc_card.png "Order Class")

This class's purpose or value is to represent a customer's order:

|Order| |
|---|---|
|boolean isInStock(OrderLine)         |OrderLine|
|double getTotalPrice(OrderLine)      |Customer|
|boolean isValidPayment (Customer)    | |
|void deliverTo (OrderLine, Customer) | |

This class's purpose or value is to represent a customer's order:
```java
public class Order {
     // returns whether or not the given items are available to order
     public boolean isInStock (OrderLine items)
     // sums the price of all the given items
     public double getTotalPrice (OrderLine items)
     // returns whether or not the customer's payment is valid
     public boolean isValidPayment (Customer customer)
     // dispatches the items to be ordered to the customer's selected address
     public void deliverTo (OrderLine items, Customer customer)
 }
 ```

This class's purpose or value is to manage something:
```java
public class Something {
     // sums the numbers in the given data
     public int getTotal (Collection<Integer> data)
	 // creates an order from the given data
     public Order makeOrder (String structuredData)
 }
```



### Use Cases

 * The user types 'fd 50' in the command window, sees the turtle move in the display window leaving a trail, and has the command added to the environment's history.

 * The user types '50 fd' in the command window and sees an error message that the command was not formatted correctly.

 * The user types 'pu fd 50 pd fd 50' in the command window and sees the turtle move twice (once without a trail and once with a trail).

 * The user changes the color of the environment's background.

