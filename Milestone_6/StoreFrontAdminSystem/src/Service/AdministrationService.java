package Service;

import Model.SalableProduct;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class AdministrationService extends Thread {
    private final InventoryManager inventoryManager;

    public AdministrationService(InventoryManager manager) {
        this.inventoryManager = manager;
    }

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(8888)) {
            System.out.println("AdminService listening on port 8888...");
            while (true) {
                try (Socket client = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                     PrintWriter out = new PrintWriter(client.getOutputStream(), true)) {

                    String command = in.readLine();
                    if ("R".equalsIgnoreCase(command)) {
                        List<SalableProduct> list = inventoryManager.loadInventory();
                        for (SalableProduct p : list) {
                            out.println(p.toJson());
                        }
                        out.println("END");
                    } else if ("U".equalsIgnoreCase(command)) {
                        List<SalableProduct> newProducts = new ArrayList<>();
                        String line;
                        while (!(line = in.readLine()).equals("END")) {
                            newProducts.add(SalableProduct.fromJson(line));
                        }
                        inventoryManager.saveInventory(newProducts);
                        out.println("UPDATE OK");
                    } else {
                        out.println("INVALID COMMAND");
                    }
                } catch (Exception e) {
                    System.err.println("Error processing client: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





