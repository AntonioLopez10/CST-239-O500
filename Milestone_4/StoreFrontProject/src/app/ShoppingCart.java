package app;

import java.util.ArrayList;
import java.util.List;

/**
 * ShoppingCart stores selected items.
 */
public class ShoppingCart {
    private List<SalableProduct> cart = new ArrayList<>();

    public void addProduct(SalableProduct product) {
        cart.add(product);
    }

    public void displayCart() {
        System.out.println("Items in your cart:");
        for (SalableProduct product : cart) {
            System.out.println(product);
        }
    }
}
