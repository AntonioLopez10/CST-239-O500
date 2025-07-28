package network;

import model.SalableProduct;
import service.FileService;
import service.InventoryManager;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread implements Runnable {
    private InventoryManager manager;
    private FileService fileService = new FileService();

    public ServerThread(InventoryManager manager) {
        this.manager = manager;
    }

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(9090)) {
            System.out.println("Waiting for admin commands...");
            while (true) {
                Socket socket = serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String command = in.readLine();
                processCommand(command);
                fileService.saveToFile("inventory.txt", manager.getAllProducts());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processCommand(String cmd) {
        String[] parts = cmd.split("\\|");
        if (parts[0].equals("U")) {
            SalableProduct p = new SalableProduct(parts[1], parts[2], Double.parseDouble(parts[3]), Integer.parseInt(parts[4]));
            manager.removeProduct(p.getName());
            manager.addProduct(p);
        } else if (parts[0].equals("R")) {
            manager.removeProduct(parts[1]);
        }
    }
}
