package app;

import java.util.Scanner;
import managers.*;
import models.*;

/**
 * Main application class that connects the inventory and cart.
 */
public class StoreFront {
    public static void main(String[] args) {
        InventoryManager inventory = new InventoryManager();
        ShoppingCart cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);
        
        
        // This will be the Main menu
        boolean running = true;
        while (running) {
            System.out.println("\n--- Welcome to the Store Front ---");
            System.out.println("1. View Inventory");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Cancel Purchase");
            System.out.println("5. Empty Cart");
            System.out.println("6. Exit");

            System.out.print("Choose an option: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                	// This will Display all items in inventory
                    System.out.println("\n--- Inventory ---");
                    int index = 1;
                    for (SalableProduct item : inventory.getInventory()) {
                        System.out.println(index++ + ". " + item);
                    }
                    break;

                case "2":
                	// Allow user to purchase
                    System.out.print("Enter item number to add to cart: ");
                    int addIndex = Integer.parseInt(scanner.nextLine()) - 1;
                    if (addIndex >= 0 && addIndex < inventory.getInventory().size()) {
                        SalableProduct product = inventory.getInventory().get(addIndex);
                        inventory.removeProduct(product);
                        cart.addToCart(product);
                        System.out.println(product.getName() + " added to cart.");
                    }
                    break;

                case "3":
                	// SHows items in the cart
                    System.out.println("\n--- Shopping Cart ---");
                    for (SalableProduct item : cart.getCartItems()) {
                        System.out.println(item);
                    }
                    break;

                case "4":
                	// cancel purchase
                    System.out.print("Enter item name to cancel: ");
                    String name = scanner.nextLine();
                    SalableProduct found = null;
                    for (SalableProduct item : cart.getCartItems()) {
                        if (item.getName().equalsIgnoreCase(name)) {
                            found = item;
                            break;
                        }
                    }
                    if (found != null) {
                        cart.removeFromCart(found);
                        inventory.addProduct(found);
                        System.out.println(found.getName() + " removed from cart.");
                    } else {
                        System.out.println("Item not found in cart.");
                    }
                    break;

                case "5":
                    cart.emptyCart();
                    System.out.println("Cart emptied.");
                    break;

                case "6":
                	// Exit
                    running = false;
                    System.out.println("Thanks for visiting!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
    }
}