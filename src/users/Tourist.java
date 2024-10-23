package users;

import java.util.ArrayList;

public class Tourist extends UserTemplate {
    private double pendingPayment =0;
    private ArrayList<TouristRequest> allTourRequests = new ArrayList<>();
    public Tourist(String name, String password, String email){
        super(name,  password, email, "tourist");
    }

    public double getPendingPayment() {
        return pendingPayment;
    }
    public void setPendingPayment(double pendingPayment) {
        this.pendingPayment = pendingPayment;
    }
    public void addTourRequest(TouristRequest touristRequest){
        allTourRequests.add(touristRequest);
    }
    public void displayAllTourRequests(){
        int i=1;
        for(TouristRequest touristRequest : allTourRequests){
            System.out.println(i+" --> Destination: "+ touristRequest.getDestination()+" || Budget: "+ touristRequest.getBudget() + " || Status: "+ (touristRequest.getIsPending() ? "Pending" : "Accepted"));
        }
    }




}
