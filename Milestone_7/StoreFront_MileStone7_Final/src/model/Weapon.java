package model;

public class Weapon extends SalableProduct {
    public Weapon(String name, String description, double price, int quantity) {
        super(name, description, price, quantity);
    }

    public void attack() {
        System.out.println(getName() + " attacks with force!");
    }
}
