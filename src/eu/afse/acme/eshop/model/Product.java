package eu.afse.acme.eshop.model;

public class Product {

    private String name;
    private double price;
    private String description;
    private Color color;
    private int size;
    private String material;

    public Product(String name, double price, String description, int size, String material) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.size = size;
        this.material = material;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Product: " +
                "name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", color=" + color +
                ", size=" + size +
                ", material='" + material + '\'' + "......";
    }

    public void updatePrice(double priceLimitA, double priceLimitB, double priceIncrease1, double priceIncrease2, double priceIncrease3) {
        if (price < priceLimitA)
            price += priceIncrease1;
        else if (price < priceLimitB)
            price += priceIncrease2;
        else
            price += priceIncrease3;
    }
}
