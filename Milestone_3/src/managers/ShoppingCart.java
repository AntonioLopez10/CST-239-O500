package managers;

import java.util.ArrayList;
import java.util.List;
import models.SalableProduct;

/**
 * Handles user shopping cart operations.
 */
public class ShoppingCart {
    private List<SalableProduct> cart;

    public ShoppingCart() {
        cart = new ArrayList<>();
    }

    public void addToCart(SalableProduct product) {
        cart.add(product);
    }

    public void removeFromCart(SalableProduct product) {
        cart.remove(product);
    }

    public List<SalableProduct> getCartItems() {
        return cart;
    }

    public void emptyCart() {
        cart.clear();
    }
}
