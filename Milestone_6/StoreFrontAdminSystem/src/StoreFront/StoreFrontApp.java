package StoreFront;

import Service.AdministrationService;
import Service.InventoryManager;

public class StoreFrontApp {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        AdministrationService adminService = new AdministrationService(manager);
        adminService.start();

        System.out.println("Store Front is running. AdminService is listening in background...");
        while (true) {
            try {
                Thread.sleep(5000);
                System.out.print(".");
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}



