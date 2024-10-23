package users;

public class TouristRequest {
    private String destination;
    private double budget;
    boolean isPending;
    public TouristRequest(String destination, double budget) {
        this.destination = destination;
        this.budget = budget;
        isPending = true;
    }
    public String getDestination() {
        return destination;
    }
    public double getBudget() {
        return budget;
    }
    void setIsPending(boolean isPending) {
        this.isPending = isPending;
    }
}
