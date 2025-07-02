package models;

/**
 * Abstract base class for any product that can be sold.
 */
public abstract class SalableProduct {
    protected String name;
    protected double price;

    public SalableProduct(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return name + " - $" + price;
    }
}
