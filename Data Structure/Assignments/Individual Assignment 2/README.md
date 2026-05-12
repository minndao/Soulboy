# Grocery Store Management System

This is a console-based Java program for WIA1002/WIB1002 Data Structure Individual Assignment 2.

## Data Structures Used

- `ArrayList<Product>` in `InventoryManager` for inventory storage.
- A self-implemented singly linked list in `CartList` for the shopping cart.
- A self-implemented stack in `Stack` for undoing the most recent cart addition.

## Files

- `Product.java` stores product details.
- `InventoryManager.java` loads, saves, searches, adds, removes, and updates products.
- `CartNode.java` is the node class for the cart linked list.
- `CartList.java` manages cart items.
- `Stack.java` manages undo actions using LIFO order.
- `GroceryStoreSystem.java` contains the main menu and program flow.
- `inventory.txt` stores inventory data in `ID/Name/Price/Stock` format.

## How to Compile and Run

```bash
javac -d bin src/*.java
java -cp bin GroceryStoreSystem
```

## MCQ Answers

1. b
2. c
3. b
4. b
5. a
6. b
