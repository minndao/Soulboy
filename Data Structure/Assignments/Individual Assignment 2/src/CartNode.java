public class CartNode{
    private Product product;
    private int quantity;
    public CartNode next;

    public CartNode (Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.next = null;
    }

    public Product getProduct() {
        return this.product;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
}