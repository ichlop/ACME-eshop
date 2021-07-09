package eu.afse.acme.eshop.data;


public class RepositoryOrder {

    private double avOrderCost;

    public RepositoryOrder() {
    }

    public double averageOrderCost(int totNumber,double totCost) {
        avOrderCost = totCost/totNumber;
        return avOrderCost;
    }
}
