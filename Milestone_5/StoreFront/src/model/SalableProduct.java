package model;

public abstract class SalableProduct implements Comparable<SalableProduct> 
{
    protected String name;
    protected double price;

    public SalableProduct(String name, double price) 
    {
        this.name = name;
        this.price = price;
    }

    public String getName() 
    {
        return name;
    }

    public double getPrice() 
    {
        return price;
    }

    @Override
    public int compareTo(SalableProduct other) 
    {
        return this.name.compareToIgnoreCase(other.name);
    }

    @Override
    public String toString() 
    {
        return name + " - $" + price;
    }
}
