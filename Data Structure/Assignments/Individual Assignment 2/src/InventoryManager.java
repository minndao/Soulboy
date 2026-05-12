import java.io.*;
import java.util.*;

public class InventoryManager {
    
    private final ArrayList<Product> inventoryList = new java.util.ArrayList<>();

    public void loadFromFile(String filename) {
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                
                String[] parts = line.split("[,/]");
                if (parts.length == 4) {
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1];
                    double price = Double.parseDouble(parts[2].trim());
                    int stock = Integer.parseInt(parts[3].trim());

                    inventoryList.add(new Product(id, name, price, stock));
                }
            }
        } catch (IOException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }

    public void saveToFile(String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Product p : inventoryList) {
                String line = p.toString();
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }

    public boolean addProduct(Product p) {
        for (Product product : inventoryList) {
            if (p.getId() == product.getId() ) {
                System.out.println("Duplicate product. Can't add.");
                return false;
            }   
        }
        inventoryList.add(p);
        return true;
    }

    public boolean removeProduct(int id) {
        return inventoryList.removeIf(Product -> Product.getId() == id);
    }

    public Product searchById(int id) {
        for (Product p : inventoryList) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    public ArrayList<Product> searchByName(String name) {
        ArrayList<Product> list = new ArrayList<>();
        for (Product p : inventoryList) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) list.add(p);
        }
        return list;
    }

    public void updateStock(int id, int newStock) {
        if (newStock < 0) {System.out.println("Invalid stock."); return;}
        for (Product p : inventoryList) {
            if (p.getId() == id) {p.setStock(newStock);  return;}
        }

        System.out.println("Item not found.");
    }

    public void displayAll() {
        System.out.printf("%-5s %-12s %-20s %-8s\n","ID", "Name", "Price(RM)", "Stock");
        System.out.println("-".repeat(42));

        for (Product p : inventoryList) {
            System.out.printf("%-5d %-12s %-20.2f %-8d%n", p.getId(), p.getName(), p.getPrice(), p.getStock());
        }
    }

    public Product getProductById(int id) {
        return searchById(id);
    }

    public boolean isAvailable(int id, int requestedQty) {
        for (Product p : inventoryList) {
            if ((p.getId()) == id && (p.getStock() >= requestedQty)) return true;
        }
        return false;
    }
    
}    

    
