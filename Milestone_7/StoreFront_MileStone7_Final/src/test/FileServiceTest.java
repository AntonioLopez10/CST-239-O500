package test;

import model.SalableProduct;
import service.FileService;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class FileServiceTest {

    @Test
    public void testLoadFromFile() {
        FileService fs = new FileService();
        List<SalableProduct> items = fs.loadFromFile("inventory.txt");

        assertNotNull(items);
        assertFalse(items.isEmpty());
        assertEquals("Sword", items.get(0).getName());
    }

    @Test
    public void testSaveToFile() {
        FileService fs = new FileService();
        List<SalableProduct> items = List.of(
            new SalableProduct("Wand", "Casts spells", 60.0, 3)
        );
        fs.saveToFile("test_output.txt", items);

        List<SalableProduct> loaded = fs.loadFromFile("test_output.txt");
        assertEquals("Wand", loaded.get(0).getName());
    }
}