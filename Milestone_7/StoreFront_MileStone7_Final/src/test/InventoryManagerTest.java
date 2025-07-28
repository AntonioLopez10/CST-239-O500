package test;

import model.SalableProduct;
import service.InventoryManager;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class InventoryManagerTest {

    @Test
    public void testAddAndFindProduct() {
        InventoryManager manager = new InventoryManager();
        SalableProduct sword = new SalableProduct("Sword", "Sharp", 50.0, 1);
        manager.addProduct(sword);

        SalableProduct found = manager.findByName("Sword");
        assertNotNull(found);
        assertEquals("Sword", found.getName());
    }

    @Test
    public void testRemoveProduct() {
        InventoryManager manager = new InventoryManager();
        manager.addProduct(new SalableProduct("Potion", "Healing", 10.0, 5));
        manager.removeProduct("Potion");

        assertNull(manager.findByName("Potion"));
    }
}
