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
        System.out.println("\t\t------------Y O U R   R E Q U E S T S -------------- ");
        for(TouristRequest touristRequest : allTourRequests){
            System.out.println("\t\t"+i+" --> Destination: "+ touristRequest.getDestination()+" || Budget: "+ touristRequest.getBudget() + " || Status: "+ (touristRequest.getIsPending() ?  "Pending" : (touristRequest.isRejected? "Rejected" : "Accepted")) );
            i++;
        }
        System.out.println("------------------------------------------------------------");
    }





}
