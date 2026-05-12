import java.util.*;

public class GroceryStoreSystem {
    // Reads an integer safely so invalid input does not crash the menu loop.
    private static Integer readInt(Scanner sc) {
        if (!sc.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            sc.nextLine();
            return null;
        }
        return sc.nextInt();
    }

    // Reads a decimal number safely for product prices.
    private static Double readDouble(Scanner sc) {
        if (!sc.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a number.");
            sc.nextLine();
            return null;
        }
        return sc.nextDouble();
    }

    public static void main(String[] args) {
        InventoryManager inv = new InventoryManager();
        CartList cart = new CartList();
        Stack stack = new Stack();
        try (Scanner sc = new Scanner(System.in)) {
            inv.loadFromFile("inventory.txt");

            int option;
            do { 
                System.out.println("\n1.Display all product 2.Search product by ID 3.Search product by name 4.Add new product 5.Remove product by ID 6.Update stock 7.Save inventory to file 8.Add to cart 9.View cart 10.Remove from cart 11.Update item quantity in cart 12.Clear cart 13.Undo 14.Checkout 15.Save & Exit");
                Integer menuInput = readInt(sc);
                if (menuInput == null) {
                    // Continue the loop after clearing invalid menu input.
                    option = 0;
                    continue;
                }
                option = menuInput;
                switch(option) {
                    case 1 -> inv.displayAll();
                    case 2 -> {
                        System.out.println("Please enter the product ID: ");
                        Integer input = readInt(sc);
                        if (input == null) break;
                        int id = input;
                        Product p = inv.getProductById(id);

                        if(p == null) System.out.println("Product not found.");
                        else {
                            System.out.println();
                            System.out.println("Product found");
                            System.out.println("ID: " + p.getId());
                            System.out.println("Name: " + p.getName());
                            System.out.println("Price: RM " + p.getPrice());
                            System.out.println("Stock: " + p.getStock());
                        }
                    }

                    case 3 -> {
                        System.out.println("Please enter the product name: ");
                        sc.nextLine();
                        String name = sc.nextLine();
                        ArrayList<Product> list = inv.searchByName(name);

                        if (list.isEmpty()) System.out.println("No product found.");
                        else {
                            for (Product product : list) {
                                System.out.println();
                                System.out.println("ID: " + product.getId());
                                System.out.println("Name: " + product.getName());
                                System.out.println("Price: RM " + product.getPrice());
                                System.out.println("Stock: " + product.getStock());
                            }
                        }

                    }
                    case 4 -> {
                        System.out.println("Please enter the ID of the new product:");
                        Integer idInput = readInt(sc);
                        if (idInput == null) break;
                        int id = idInput;
                        System.out.println("Please enter the name of the new product:");
                        sc.nextLine();
                        String name = sc.nextLine();
                        System.out.println("Please enter the price of the new product: RM");
                        Double priceInput = readDouble(sc);
                        if (priceInput == null) break;
                        double price = priceInput;
                        System.out.println("Please enter the stock of the new product:");
                        Integer stockInput = readInt(sc);
                        if (stockInput == null) break;
                        int stock = stockInput;

                        if (inv.addProduct(new Product(id, name, price, stock))) System.out.println("Item added.");
                        // Add new product 
                    }
                    case 5 -> {
                        System.out.println("Please enter the ID of the product: ");
                        Integer input = readInt(sc);
                        if (input == null) break;
                        int id = input;
                        // Do not delete inventory records that active cart nodes still reference.
                        if (cart.findItem(id) != null) {
                            System.out.println("Cannot remove product while it is in the cart.");
                        } else if (inv.removeProduct(id)) {
                            System.out.println("Item removed.");
                        } else {
                            System.out.println("Item not found.");
                        }
                        // Remove product by ID
                    }
                    case 6 -> {
                        System.out.println("Please enter the ID of the product: ");
                        Integer idInput = readInt(sc);
                        if (idInput == null) break;
                        int id = idInput;
                        System.out.println("Please enter the new stock of the product: ");
                        Integer stockInput = readInt(sc);
                        if (stockInput == null) break;
                        int newStock = stockInput;

                        inv.updateStock(id, newStock);
                        // Update stock
                    }
                    case 7 -> {
                        inv.saveToFile("inventory.txt");
                        System.out.println("Inventory saved.");
                        // Save inventory to file
                    }
                    case 8 -> {
                        System.out.println("Enter the ID of product desired: ");
                        Integer input = readInt(sc);
                        if (input == null) break;
                        int id = input;

                        Product p = inv.getProductById(id);

                        if (p == null) {
                            System.out.println("Product not found.");
                        } else {
                            System.out.println("Please enter desired quantity: ");
                            Integer qtyInput = readInt(sc);
                            if (qtyInput == null) break;
                            int qty = qtyInput;
                            if (qty <= 0) System.out.println ("Invalid quantity.");

                            else if (!inv.isAvailable(id, qty)) {
                                System.out.println("Requested quantity not available.");
                            } else {
                                cart.addItem(p, qty);
                                p.setStock(p.getStock() - qty);
                                stack.push(new CartNode(p, qty));
                                System.out.println("Item added to cart.");
                            }
                        }
                        // Add to cart
                    }
                    case 9 -> {
                        cart.displayCart();
                        // View cart
                    }
                    case 10 -> {
                        System.out.println("Enter the ID of product desired: ");
                        Integer input = readInt(sc);
                        if (input == null) break;
                        int id = input;

                        Product p = inv.getProductById(id);

                        if (p == null) {
                            System.out.println("This item no longer exists in the inventory.");
                        } else {
                            CartNode removed = cart.removeItem(id);
                            if (removed == null) {
                                System.out.println("Item not found.");
                            } else {
                                p.setStock(p.getStock() + removed.getQuantity());
                                System.out.println("Item removed.");
                            }
                        }
                        // Remove from cart
                    }
                    case 11 -> {
                        System.out.println("Enter the desired product ID: ");
                        Integer input = readInt(sc);
                        if (input == null) break;
                        int id = input;

                        CartNode item = cart.findItem(id);

                        if (item == null) {
                            System.out.println("Item not found in cart.");
                        } else {
                            System.out.println("Enter the desired quantity: ");
                            Integer qtyInput = readInt(sc);
                            if (qtyInput == null) break;
                            int newQty = qtyInput;
                            int oldQty = item.getQuantity();
                            Product p = item.getProduct();

                            int diff = newQty - oldQty;

                            if (newQty <= 0) {
                                System.out.println("Invalid quantity.");
                            } else if (diff > p.getStock()) {
                                System.out.println("Insufficient stock.");
                            } else {
                                p.setStock(p.getStock() - diff);
                                cart.updateQuantity(id, newQty);
                                // The cart quantity changes, but the undo stack still stores the original add action.
                                System.out.println("Cart updated.");
                            }
                        }
                        // Update item quantity in cart
                    }
                    case 12 -> {
                        cart.restoreAllStock();
                        cart.clear();
                        stack.setTop(null);
                        System.out.println("Cart cleared.");
                        // Clear cart
                    }
                    case 13 -> {
                        CartNode action = stack.pop();

                        if (action == null) {
                            System.out.println("Nothing to undo.");
                        } else {
                            Product p = action.getProduct();
                            int qty = action.getQuantity();

                            CartNode item = cart.findItem(p.getId());
                            if (item == null) {System.out.println("Item no longer exist in cart."); break;}
                            // Undo only the quantity that still exists after possible cart updates.
                            int quantityToUndo = Math.min(qty, item.getQuantity());
                            item.setQuantity(item.getQuantity() - quantityToUndo);
                            p.setStock(p.getStock() + quantityToUndo);
                            if (item.getQuantity() == 0) cart.removeItem(p.getId());
                            System.out.println("Undone.");
                        }
                        // Undo
                    }
                    case 14 -> {
                        stack.setTop(null);
                        
                        if (cart.isEmpty()) {
                            System.out.println("Cart is empty.");
                        } else {
                            System.out.println("===================================== BILL =====================================");
                            cart.displayCart();

                            cart.clear();

                            System.out.println("Save inventory? (Y/N): ");
                            String ans = sc.next();

                            if (ans.equalsIgnoreCase("Y")) {
                                inv.saveToFile("inventory.txt");
                                System.out.println("Saved.");
                            }

                            System.out.println("Check out complete.");
                        }


                    
                        // Checkout
                    }
                    case 15-> {
                        inv.saveToFile("inventory.txt");
                        System.out.println("Saved. Exiting...");
                    }
                    default -> System.out.println("Invalid option.");

                }
            } while (option != 15);
        }
        }
    }

    

