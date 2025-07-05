package app;

import java.util.List;
import java.util.Scanner;

/**
 * StoreFront is the main entry point of the application.
 */
public class StoreFront {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        ShoppingCart cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);

        manager.loadInventoryFromJSON("JSON/inventory.json");

        List<SalableProduct> products = manager.getInventory();
        boolean running = true;

        while (running) {
            System.out.println("\nAvailable Products:");
            for (int i = 0; i < products.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, products.get(i));
            }
            System.out.println("0. Checkout");

            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                running = false;
            } else if (choice > 0 && choice <= products.size()) {
                cart.addProduct(products.get(choice - 1));
                System.out.println("Item added to cart.");
            } else {
                System.out.println("Invalid choice.");
            }
        }

        cart.displayCart();
        System.out.println("Thanks for shopping!");
    }
}
