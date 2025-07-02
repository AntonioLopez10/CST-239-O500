package models;

/**
 * Represents a health item that restores points.
 */
public class Health extends SalableProduct {
    private int restorePoints;

    public Health(String name, double price, int restorePoints) {
        super(name, price);
        this.restorePoints = restorePoints;
    }

    public int getRestorePoints() { return restorePoints; }

    @Override
    public String toString() {
        return "Health Item: " + name + " | Restores: " + restorePoints + " HP | Price: $" + price;
    }
}
