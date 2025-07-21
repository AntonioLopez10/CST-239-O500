package Service;

import Model.SalableProduct;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    private final String FILE_NAME = "inventory.json";

    public List<SalableProduct> loadInventory() {
        List<SalableProduct> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty())
                    list.add(SalableProduct.fromJson(line));
            }
        } catch (IOException e) {
            System.out.println("Inventory file not found, starting empty.");
        }
        return list;
    }

    public void saveInventory(List<SalableProduct> products) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (SalableProduct p : products) {
                writer.println(p.toJson());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



