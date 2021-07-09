package eu.afse.acme.eshop.model;

import java.util.Date;
import java.util.List;

public class Order {
    private Date orderDate;
    private String id;
    private String shipment;
    private List<Product> products;
    private Customer customer;
    private PaymentType paymentType;

    private final double busDiscount = 0.2;
    private final double govDiscount = 0.5;
    private final double wirePayDiscount = 0.1;
    private final double creditPayDiscount = 0.15;

    public Order(Date orderDate, String id, String shipment, List<Product> products, Customer customer, PaymentType paymentType) {
        this.orderDate = orderDate;
        this.id = id;
        this.shipment = shipment;
        this.products = products;
        this.customer = customer;
        this.paymentType = paymentType;
    }

    public Order(List<Product> products) {
        this.products = products;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

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

    public void setProducts(List<Product> products) {
        this.products = products;
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

    public double totalOrderCost () {
        double totalCost = 0;
            for (Product product : products) {
                totalCost += product.getPrice();
            }
        return totalCost;

    }

    public double totalCostWithDiscount() {

        //private const
        double totalOrderCost= totalOrderCost();

        switch (getCustomer().getCustomerType()) {
            case INDIVIDUAL:
                if (PaymentType.CREDIT_CARD.equals(paymentType)) {
                    totalOrderCost -= creditPayDiscount*totalOrderCost;
                } else if (paymentType.WIRE_TRANSFER.equals(paymentType)) {
                    totalOrderCost -= wirePayDiscount*totalOrderCost;
                }
                break;
            case BUSINESS:
                totalOrderCost -= totalOrderCost*busDiscount;
                if (PaymentType.CREDIT_CARD.equals(paymentType)) {
                    totalOrderCost -= creditPayDiscount*totalOrderCost;
                } else if (paymentType.WIRE_TRANSFER.equals(paymentType)) {
                    totalOrderCost -= wirePayDiscount*totalOrderCost;
                }
                break;
            case GOVERMENT:
                totalOrderCost -= totalOrderCost*govDiscount;
                if (PaymentType.CREDIT_CARD.equals(paymentType)) {
                    totalOrderCost -= creditPayDiscount*totalOrderCost;
                } else if (paymentType.WIRE_TRANSFER.equals(paymentType)) {
                    totalOrderCost -= wirePayDiscount*totalOrderCost;
                }
                break;
            default:
                System.out.println("There is nothing to compute");
        }
        return totalOrderCost;
    }
}