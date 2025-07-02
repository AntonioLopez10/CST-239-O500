package models;

/**
 * Represents a Weapon that is a salable product.
 */
public class Weapon extends SalableProduct implements Comparable<Weapon> {
    private String material;

    public Weapon(String name, double price, String material) {
        super(name, price);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public int compareTo(Weapon other) {
        return this.name.compareToIgnoreCase(other.name);
    }

    @Override
    public String toString() {
        return "Weapon: " + name + " | Material: " + material + " | Price: $" + price;
    }
}
