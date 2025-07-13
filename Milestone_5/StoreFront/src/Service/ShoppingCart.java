package Service;

import model.SalableProduct;
import java.util.*;

public class ShoppingCart 
{
    private List<SalableProduct> cartItems;

    public ShoppingCart() 
    {
        cartItems = new ArrayList<>();
    }

    public void addItem(SalableProduct item) 
    {
        cartItems.add(item);
    }

    public void removeItem(SalableProduct item) 
    {
        cartItems.remove(item);
    }

    public List<SalableProduct> getCartItems() 
    {
        return cartItems;
    }

    public double calculateTotal() 
    {
        double total = 0.0;
        for (SalableProduct item : cartItems) {
            total += item.getPrice();
        }
        return total;
    }
}
