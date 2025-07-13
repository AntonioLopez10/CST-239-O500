package app;

import Service.InventoryManager;
import Service.ShoppingCart;
import model.*;

public class StoreFront 
{
    public static void main(String[] args) 
    {
        InventoryManager inventoryManager = new InventoryManager();
        ShoppingCart cart = new ShoppingCart();

        // Add some products to the inventory
        inventoryManager.addProduct(new Weapon("Axe", 45.99));
        inventoryManager.addProduct(new Weapon("Sword", 59.99));
        inventoryManager.addProduct(new Weapon("Dagger", 25.50));

        // Sort by name 
        System.out.println("Inventory sorted by name (A-Z):");
        inventoryManager.sortByName(true);
        for (SalableProduct product : inventoryManager.getInventory()) 
        {
            System.out.println(product);
        }

        // Sort by price 
        System.out.println("\nInventory sorted by price (high to low):");
        inventoryManager.sortByPrice(false);
        for (SalableProduct product : inventoryManager.getInventory()) 
        {
            System.out.println(product);
        }

        // Simulate adding items to the cart
        cart.addItem(new Weapon("Sword", 59.99));
        cart.addItem(new Weapon("Dagger", 25.50));

        // Display cart contents
        System.out.println("\nCart Items:");
        for (SalableProduct item : cart.getCartItems()) 
        {
            System.out.println(item);
        }

        // Display total
        System.out.printf("\nTotal: $%.2f\n", cart.calculateTotal());
    }
}
