package eu.afse.acme.eshop.data;

import java.util.ArrayList;
import java.util.List;

public class RepositoryOrder {

    private List<String> ordersIds;

    public RepositoryOrder() {
        this.ordersIds = new ArrayList<>();
    }

    public void addNewOrderId(String id) {
        ordersIds.add(id);
    }

    public boolean existsOrderId(String id) {
       return ordersIds.contains(id);
    }

    //TODO remove order id from list
    public void removeOrderId(String orderId) {
        if (ordersIds.contains(orderId))
            ordersIds.remove(orderId);
    }

    public List<String> getOrdersIds() {
        return ordersIds;
    }

    public void setOrdersIds(List<String> ordersIds) {
        this.ordersIds = ordersIds;
    }

}
