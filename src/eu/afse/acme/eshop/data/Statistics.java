package eu.afse.acme.eshop.data;

public class Statistics {

    private int totalNumber;
    private double totalCost;

    public Statistics(int totalNumber, double totalCost) {
        this.totalNumber = totalNumber;
        this.totalCost = totalCost;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public void increaseTotalNumber() {
        this.totalNumber++;
    }

    public void increaseTotalCost(double cost) {
        this.totalCost += cost;
    }



    @Override
    public String toString() {
        return "Statistics{" +
                "totalNumber=" + totalNumber +
                ", totalCost=" + totalCost +
                '}';
    }
}
