package AdminApp;

import Model.SalableProduct;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminClientApp {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8888);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter command [R/U]: ");
            String cmd = scanner.nextLine().trim().toUpperCase();
            out.println(cmd);

            if ("R".equals(cmd)) {
                String response;
                while (!(response = in.readLine()).equals("END")) {
                    SalableProduct p = SalableProduct.fromJson(response);
                    System.out.println(p);
                }
            } else if ("U".equals(cmd)) {
                List<SalableProduct> newProducts = new ArrayList<>();
                System.out.print("Enter product name: ");
                String name = scanner.nextLine();
                System.out.print("Enter product price: ");
                double price = Double.parseDouble(scanner.nextLine());
                newProducts.add(new SalableProduct(name, price));

                for (SalableProduct p : newProducts) {
                    out.println(p.toJson());
                }
                out.println("END");

                System.out.println("Server says: " + in.readLine());
            } else {
                System.out.println("Invalid command.");
            }

        } catch (IOException e) {
            System.err.println("Connection failed: " + e.getMessage());
        }
    }
}




