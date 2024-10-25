package users;

import java.util.ArrayList;

public class Admin extends UserTemplate {
    private ArrayList<IncomingTourRequest> incomingRequests = new ArrayList<>();
    public Admin(String name, String password, String email){
        super(name,password,email,"admin");
    }

    public void addRequest(TouristRequest request, int touristId, String touristName, String touristEmail){
        IncomingTourRequest incomingRequest = new IncomingTourRequest(request.getDestination(), request.getBudget(), touristId, touristName, touristEmail);
        incomingRequests.add(incomingRequest);
    }
    public void viewAllIncomingRequests(){
        int i=1;
        for(IncomingTourRequest touristRequest : incomingRequests){
            System.out.println(i+" --> Destination: "+ touristRequest.getDestination()+" || Budget: "+ touristRequest.getBudget() + " || Status: "+ (touristRequest.getIsPending() ? "Pending" : "Accepted"));
            i++;
        }
    }

}
