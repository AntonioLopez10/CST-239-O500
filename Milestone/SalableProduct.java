package app;

public class SalableProduct {
	
	private String name;
	private String description;
	private double price;
	private int quantity;
	
	public SalableProduct(String name, String description, double price, int quantity)
	{
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}
	
	/** Name of product */
	public String getName() {return name;}
	
	/** description of product */
	public String getDescription() { return description; }
	
	/** Price of product */
	public double getPrice() {return price; }
	
	/** quantity of product */
	public void setQuantity(int quantity) {this.quantity = quantity; }
	
	
	/** defines how the object is represented*/
	public String toString()
	{
	return name + "(" + description + ") - $" + price + "[Qty: " + quantity + "]";
	}

	/** prints the object */
	public static void main (String[] args)
	{
		// TODO auto-generated method stub
		SalableProduct product = new SalableProduct("Laptop", "15-inch display", 999.99, 5);
		System.out.println(product);
		}
}
