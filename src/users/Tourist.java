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
    public ArrayList<TouristRequest> getAllTourRequests() {
        return allTourRequests;
    }
    public void addTourRequest(TouristRequest touristRequest){
        touristRequest.setRequestId(allTourRequests.size()+1);
        allTourRequests.add(touristRequest);
    }

    public void displayAllTourRequests(){
        int i=1;
        for(TouristRequest touristRequest : allTourRequests){
            System.out.println(i+" --> Destination: "+ touristRequest.getDestination()+" || Budget: "+ touristRequest.getBudget() + " || Status: "+ (touristRequest.getIsPending() ?  "Pending" : (touristRequest.isRejected? "Rejected" : "Accepted")   ) +  " || pending:"+ touristRequest.getIsPending()+ " || Rejected: "+ touristRequest.getIsRejected());
            i++;
        }
    }





}
