package Model;

public class SalableProduct {
    private String name;
    private double price;

    public SalableProduct() {}

    public SalableProduct(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public static SalableProduct fromJson(String json) {
        json = json.replace("{", "").replace("}", "").trim();
        String[] parts = json.split(",");
        String name = "", priceStr = "";
        for (String part : parts) {
            if (part.contains("name")) name = part.split(":")[1].replace("\"", "").trim();
            if (part.contains("price")) priceStr = part.split(":")[1].trim();
        }
        return new SalableProduct(name, Double.parseDouble(priceStr));
    }

    public String toJson() {
        return String.format("{\"name\":\"%s\",\"price\":%.2f}", name, price);
    }

    @Override
    public String toString() {
        return name + " - $" + price;
    }
}




