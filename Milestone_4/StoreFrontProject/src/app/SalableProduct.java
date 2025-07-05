package app;

/**
 * A class representing a salable product in the inventory.
 */
public class SalableProduct {
    private String id;
    private String name;
    private double price;

    public SalableProduct() {
        // Required for Gson
    }

    public SalableProduct(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return name + " - $" + price;
    }
}
