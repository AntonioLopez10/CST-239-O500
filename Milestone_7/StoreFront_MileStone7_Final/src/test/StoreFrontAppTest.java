package test;

import model.SalableProduct;
import service.InventoryManager;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class StoreFrontAppTest {

    @Test
    public void testInventorySetup() {
        InventoryManager manager = new InventoryManager();
        manager.addProduct(new SalableProduct("Hammer", "Strong weapon", 20.0, 4));

        SalableProduct p = manager.findByName("Hammer");
        assertNotNull(p);
        assertEquals(20.0, p.getPrice(), 0.001);
    }
}
