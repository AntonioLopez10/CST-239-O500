package Service;

import model.SalableProduct;
import java.util.*;

public class InventoryManager 
{
    private List<SalableProduct> inventory;

    public InventoryManager() 
    {
        inventory = new ArrayList<>();
    }

    public void addProduct(SalableProduct product) 
    {
        inventory.add(product);
    }

    public List<SalableProduct> getInventory() 
    {
        return inventory;
    }

    public void sortByName(boolean ascending) 
    {
        if (ascending) 
        {
            inventory.sort(Comparator.naturalOrder());
        } else {
            inventory.sort(Comparator.reverseOrder());
        }
    }

    public void sortByPrice(boolean ascending) 
    {
        if (ascending) 
        {
            inventory.sort(Comparator.comparingDouble(SalableProduct::getPrice));
        } else {
            inventory.sort(Comparator.comparingDouble(SalableProduct::getPrice).reversed());
        }
    }
}
