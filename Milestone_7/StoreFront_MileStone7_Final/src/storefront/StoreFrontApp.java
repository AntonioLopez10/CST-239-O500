package storefront;

import model.SalableProduct;
import network.ServerThread;
import service.FileService;
import service.InventoryManager;
import java.util.List;

public class StoreFrontApp {
    public static void main(String[] args) {
        FileService fileService = new FileService();
        InventoryManager manager = new InventoryManager();

        List<SalableProduct> loaded = fileService.loadFromFile("inventory.txt");
        manager.setInventory(loaded);

        for (SalableProduct p : manager.getAllProducts()) {
            System.out.println(p);
        }

        new Thread(new ServerThread(manager)).start();
    }
}
