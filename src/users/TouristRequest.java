package users;

public class TouristRequest {
    private String destination;
    private double budget;
    boolean isPending;
    boolean isRejected;
    private int requestId;
    public TouristRequest(String destination, double budget) {
        this.destination = destination;
        this.budget = budget;
        isPending = true;
        isRejected = false;
    }
    public String getDestination() {
        return destination;
    }
    public double getBudget() {
        return budget;
    }
    public int getRequestId() {return requestId;}
    public boolean getIsPending() { return isPending;}
    public boolean getIsRejected() { return isRejected;}
    public void setIsPending(boolean isPending) {
        this.isPending = isPending;
    }
    public void setIsRejected(boolean isRejected) {
        this.isRejected = isRejected;
    }
    public void setRequestId(int requestId) { this.requestId = requestId; }

}
