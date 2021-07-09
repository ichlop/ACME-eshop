package eu.afse.acme.eshop.data;

import eu.afse.acme.eshop.model.Customer;
import eu.afse.acme.eshop.model.CustomerType;
import eu.afse.acme.eshop.model.Order;
import eu.afse.acme.eshop.model.PaymentType;

import java.util.HashMap;
import java.util.Map;

public class RepositoryCustomer {

    private Map<String, Statistics> customerOrder;
    private int indCounter;
    private int busCounter;
    private int govCounter;
    private double valueInd;
    private double valueBus;
    private double valueGov;
    private int cashCounter;
    private int creditCounter;
    private int wireCounter;
    private double cashTypeTotal;
    private double wireTypeTotal;
    private double creditTypeTotal;
    private int totNumber;
    private double totCost;

    public RepositoryCustomer() {
        this.customerOrder = new HashMap<>();
    }

    public Map<String, Statistics> getCustomerOrder() {
        return customerOrder;
    }

    public int getTotNumber() {
        return totNumber;
    }

    public void setTotNumber(int totNumber) {
        this.totNumber = totNumber;
    }

    public double getTotCost() {
        return totCost;
    }

    public void setTotCost(double totCost) {
        this.totCost = totCost;
    }

    public void setCustomerOrder(Map<String, Statistics> customerOrder) {
        this.customerOrder = customerOrder;
    }

    public void addNewOrderStatistics(Order order) {
        if (customerOrder.containsKey(order.getCustomer().getId())) {
            Statistics value = customerOrder.get(order.getCustomer().getId());
            value.increaseTotalNumber();
            value.increaseTotalCost(order.totalOrderCost());
            customerOrder.put(order.getCustomer().getId(), value);
        } else {
            //First time
            Statistics value = new Statistics(1, order.totalOrderCost());
            customerOrder.put(order.getCustomer().getId(), value);
        }
    }

    public void addTypeOrderStatistics(Order order) {
        if (order.getCustomer().getCustomerType().equals(CustomerType.INDIVIDUAL)) {
            valueInd += order.totalOrderCost();
            indCounter ++ ;
        } else if (order.getCustomer().getCustomerType().equals(CustomerType.BUSINESS)) {
            valueBus += order.totalOrderCost();
            busCounter++;
        } else if (order.getCustomer().getCustomerType().equals(CustomerType.GOVERMENT)){
            valueGov += order.totalOrderCost();
            govCounter ++;
        }
    }

    public void addPaymentMethodStatistics(Order order) {
        if (order.getPaymentType().equals(PaymentType.CASH)) {
            cashTypeTotal += order.totalOrderCost();
            cashCounter ++ ;
            totNumber ++;
            totCost=+ order.totalOrderCost();
        }
        else if (order.getPaymentType().equals(PaymentType.WIRE_TRANSFER)) {
            wireTypeTotal += order.totalOrderCost();
            wireCounter ++ ;
            totNumber++;
            totCost=+ order.totalOrderCost();
        } else if (order.getPaymentType().equals(PaymentType.CREDIT_CARD)){
            creditTypeTotal += order.totalOrderCost();
            creditCounter ++ ;
            totNumber++;
            totCost=+ order.totalOrderCost();
        }
    }

    @Override
    public String toString() {
        return "RepositoryCustomer" +"\n"+
                " Number and cost for a particular customer: " +
                "Orders per customerId=" + customerOrder + "\n"+
                " Number and cost per customer category: " +
                " INDIVIDUAL Type orders=" + indCounter +
                ", BUSINESS  Type orders=" + busCounter +
                ", GOVERNMENT  Type orders=" + govCounter +
                "[ TotalCost for Individuals=" + valueInd +
                ", TotalCost for Business=" + valueBus +
                ", TotalCost for Governments=" + valueGov +"] \n"+
                " Number and cost per payment method: " +
                " Cash orders=" + cashCounter +
                ", Credit orders=" + creditCounter +
                ", Wire orders=" + wireCounter +
                "[ Total cost for Cash payments=" + cashTypeTotal +
                ", Total cost for Wire payments=" + wireTypeTotal +
                ", Total cost for Credit payments=" + creditTypeTotal +"]";
    }
}

