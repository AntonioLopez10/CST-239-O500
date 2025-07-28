package test;

import model.SalableProduct;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SalableProductTest {

    @Test
    public void testConstructor() {
        SalableProduct product = new SalableProduct("Potion", "Restores HP", 10.0, 5);
        assertEquals("Potion", product.getName());
        assertEquals("Restores HP", product.getDescription());
        assertEquals(10.0, product.getPrice(), 0.001);
        assertEquals(5, product.getQuantity());
    }

    @Test
    public void testSetQuantity() {
        SalableProduct product = new SalableProduct("Potion", "Restores HP", 10.0, 5);
        product.setQuantity(8);
        assertEquals(8, product.getQuantity());
    }

    @Test
    public void testToString() {
        SalableProduct product = new SalableProduct("Elixir", "Restores MP", 12.5, 3);
        String output = product.toString();
        assertTrue(output.contains("Elixir"));
        assertTrue(output.contains("Restores MP"));
        assertTrue(output.contains("$12.5"));
    }
}

