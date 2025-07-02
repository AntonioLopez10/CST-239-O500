package models;

/**
 * Represents an Armor item.
 */
public class Armor extends SalableProduct {
    private String type;

    public Armor(String name, double price, String type) {
        super(name, price);
        this.type = type;
    }

    public String getType() { return type; }

    @Override
    public String toString() {
        return "Armor: " + name + " | Type: " + type + " | Price: $" + price;
    }
}
