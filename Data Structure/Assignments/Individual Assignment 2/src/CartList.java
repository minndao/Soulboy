public class CartList  {
    private CartNode head;

    public CartList() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addItem(Product p, int qty) {  
        if( head == null ) {
            head = new CartNode(p,qty);
            return;
        }

        CartNode curr = head;    
        while (true) { 
            if (curr.getProduct().equals(p)) {
                curr.setQuantity(qty + curr.getQuantity());
                return;
            }

            if (curr.next == null) {
                break;
            }

            curr = curr.next;
        }        

        curr.next = new CartNode(p, qty);
    }

    public CartNode removeItem(int productId) {
        if (head == null) return null;
        if (head.getProduct().getId() == productId) {
            CartNode removed = head;
            head = head.next;
            removed.next = null;
            return removed;
        }

        CartNode curr = head;
        
        while (curr.next != null && curr.next.getProduct().getId() != productId) {
            curr = curr.next;
        }

        if (curr.next != null) {
            CartNode removed = curr.next;
            curr.next = curr.next.next;
            removed.next = null;
            return removed;
        }

        return null;
    }

    public void updateQuantity(int productId, int newQty) {
        if (head == null) return;
        if (head.getProduct().getId() == productId) {
            head.setQuantity(newQty);
            return;
        }
        
        CartNode curr = head;

        while (curr.next != null) {
            if (curr.next.getProduct().getId() == productId) {
                curr.next.setQuantity(newQty);
                return;
            }
            curr = curr.next;
        }
    }

    public CartNode findItem(int productId) {
        if (head == null) return null;

        CartNode curr = head;

        while (curr != null) {
            if (curr.getProduct().getId() == productId) return curr;
            curr = curr.next;
        }

        return null;
    }

    public void displayCart() {
        System.out.printf("%-7s %-12s %-15s %-15s %-15s\n","ID", "Name", "Price", "Quantity", "Subtotals");
        System.out.println("-".repeat(65));

        if (head == null) {System.out.println("Empty cart!"); return;}
        CartNode curr = head;

        while (curr != null) {
            Product p = curr.getProduct();
            // Format money values to two decimal places for a cleaner bill.
            System.out.printf("%-5d %-12s RM %-10.2f %-15d RM %-15.2f\n", p.getId(), p.getName(), p.getPrice(), curr.getQuantity(), p.getPrice() * curr.getQuantity());
            curr = curr.next;
        }

        System.out.printf("RM %48.2f\n",calculateTotal());
    }

    public double calculateTotal() {
        double totals = 0.00;
        if (head == null) return totals;
        CartNode curr = head;

        while (curr != null) { 
            totals = curr.getQuantity() * curr.getProduct().getPrice() + totals;
            curr = curr.next;
        }  
        return totals;
    }

    public void clear() {
        head = null;
    }

    public CartNode removeLast() {
        if (head == null) return null;

        if (head.next == null) {
            CartNode removed = head;
            head = null;
            return removed;
        }

        CartNode curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }

        CartNode removed = curr.next;
        curr.next = null;
        return removed;
    }

    public int getSize() {
        if (head == null) return 0;
        CartNode curr = head;

        int sum = 0;

        while (curr != null) {
            sum++;
            curr = curr.next;
        }

        return sum;
    }

    public void undo() {
        if (head == null) return;

        if (head.next == null) {
            head = null;
            return;
        }

        CartNode curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }

        // remove last node
        curr.next = null;
    }

    public void restoreAllStock() {
        CartNode curr = head;

        while (curr != null) {
            Product p = curr.getProduct();
            p.setStock(p.getStock() + curr.getQuantity());
            curr = curr.next;
        }
    }
}
