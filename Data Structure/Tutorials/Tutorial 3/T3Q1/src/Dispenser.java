//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Dispenser {

    private String nameOfProduct;
    private double priceOfProduct;
    private int numberOfProduct;

    Dispenser(int nameOfProduct, double priceOfProduct, int numberOfProduct) {
        this.nameOfProduct = nameOfProduct;
        this.priceOfProduct = priceOfProduct;
        this.numberOfProduct = numberOfProduct;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public double getPriceOfProduct() {
        return priceOfProduct;
    }

    public void getPriceOfProduct(double priceOfProduct){
        this.priceOfProduct = priceOfProduct;
    }

    public int getNumberOfProduct() {
        return numberOfProduct;
    }

    public void setNumberOfProduct(int numberOfProduct) {
        this.numberOfProduct = numberOfProduct;
    }

    public void purchase() {
        numberOfProduct --1;
    }
}