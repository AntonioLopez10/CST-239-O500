package app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * InventoryManager handles product loading and access.
 */
public class InventoryManager {
    private List<SalableProduct> inventory = new ArrayList<>();

    public void loadInventoryFromJSON(String filePath) {
        try {
            inventory = FileService.readJSON(filePath);
            System.out.println("Inventory loaded successfully.");
        } catch (IOException e) {
            System.err.println("Failed to load inventory: " + e.getMessage());
        }
    }

    public List<SalableProduct> getInventory() {
        return inventory;
    }
}
