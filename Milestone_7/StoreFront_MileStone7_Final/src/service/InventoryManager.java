package service;

import model.SalableProduct;
import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    private List<SalableProduct> inventory = new ArrayList<>();

    public void addProduct(SalableProduct product) {
        inventory.add(product);
    }

    public void removeProduct(String name) {
        inventory.removeIf(p -> p.getName().equalsIgnoreCase(name));
    }

    public SalableProduct findByName(String name) {
        return inventory.stream().filter(p -> p.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public List<SalableProduct> getAllProducts() {
        return inventory;
    }

    public void setInventory(List<SalableProduct> list) {
        this.inventory = list;
    }
}
