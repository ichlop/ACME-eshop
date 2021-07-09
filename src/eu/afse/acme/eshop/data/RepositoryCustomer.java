package eu.afse.acme.eshop.data;

import eu.afse.acme.eshop.model.Customer;
import eu.afse.acme.eshop.model.CustomerType;
import eu.afse.acme.eshop.model.Order;

import java.util.HashMap;
import java.util.Map;

public class RepositoryCustomer {

    private Map<String, Statistics> customerOrder;
    private Map<CustomerType, Statistics> customerTypeOrder;
    private int indCounter;
    private int busCounter;
    private int govCounter;
    private double valueInd;
    private double valueBus;
    private double valueGov;

    public RepositoryCustomer() {
        this.customerOrder = new HashMap<>();
    }

    public Map<String, Statistics> getCustomerOrder() {
        return customerOrder;
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
            }
        else if (order.getCustomer().getCustomerType().equals(CustomerType.BUSINESS)) {
            valueBus += order.totalOrderCost();
            busCounter++;
        } else {
            valueGov += order.totalOrderCost();
            govCounter ++;
        }
    }


    @Override
    public String toString() {
        return "RepositoryCustomer{" +
                "customerOrder=" + customerOrder +
                ", indCounter=" + indCounter +
                ", busCounter=" + busCounter +
                ", govCounter=" + govCounter +
                '}';
    }
}

