package users;

public class TouristRequest {
    private String destination;
    private double budget;
    public TouristRequest(String destination, double budget) {
        this.destination = destination;
        this.budget = budget;
    }
    public String getDestination() {
        return destination;
    }
    public double getBudget() {
        return budget;
    }
}
