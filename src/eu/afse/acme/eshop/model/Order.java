package eu.afse.acme.eshop.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Date orderDate;
    private String id;
    private String shipment;
    private final List<Product> products = new ArrayList<>();
    private Customer customer;

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShipment() {
        return shipment;
    }

    public void setShipment(String shipment) {
        this.shipment = shipment;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order: " +
                "orderDate=" + orderDate +
                ", id='" + id + '\'' +
                ", shipment='" + shipment + '\'' +
                ", products=" + products +
                ", customer=" + customer;
    }

    public void create(Product product) {
        products.add(product);
    }

    public double calculateTotal() {
        double calculation = 0;
//        for (int index = 0 ; index < products.size(); index ++){
//            calculation += products.get(index).getPrice();
//        }

        for (Product product : products) {
            calculation += product.getPrice();
        }

//      calculation = products.stream().map(product ->product.getPrice())
//              .reduce( (value1, value2) -> value1+value2).get();

        return calculation;
    }
}