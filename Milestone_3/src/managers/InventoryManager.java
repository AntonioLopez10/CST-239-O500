package managers;

import java.util.ArrayList;
import java.util.List;
import models.*;

/**
 * Handles the store's inventory operations.
 */
public class InventoryManager {
    private List<SalableProduct> inventory;

    public InventoryManager() {
        inventory = new ArrayList<>();
        initializeInventory();
    }

    private void initializeInventory() {
        inventory.add(new Weapon("Longsword", 120.0, "Steel"));
        inventory.add(new Armor("Leather Armor", 85.0, "Light"));
        inventory.add(new Health("Health Potion", 50.0, 30));
    }

    public void addProduct(SalableProduct product) {
        inventory.add(product);
    }

    public void removeProduct(SalableProduct product) {
        inventory.remove(product);
    }

    public List<SalableProduct> getInventory() {
        return inventory;
    }
}
