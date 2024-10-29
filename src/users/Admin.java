package users;

import java.util.ArrayList;

public class Admin extends UserTemplate {
    private final ArrayList<IncomingTourRequest> incomingRequests = new ArrayList<>();
    public Admin(String name, String password, String email){
        super(name,password,email,"admin");
    }

    public void addRequest(TouristRequest request, int touristId, String touristName, String touristEmail){
        if(!request.getIsPending()) return;
        IncomingTourRequest incomingRequest = new IncomingTourRequest(request.getDestination(), request.getBudget(), touristId, touristName, touristEmail);
        incomingRequest.setRequestId(request.getRequestId());
        incomingRequests.add(incomingRequest);
    }
    public int viewAllIncomingRequests(){
        int i=1;
        System.out.println("\t\t----------------INCOMING REQUESTS-------------------");
        if(incomingRequests.isEmpty()) System.out.println("\t\tNo Requests Found");;
        for(IncomingTourRequest touristRequest : incomingRequests){
            System.out.println("\t\t"+i+" --> Destination: "+ touristRequest.getDestination()+" || Budget: "+ touristRequest.getBudget() + " By: "+ touristRequest.touristName   + " || Status: "+ (touristRequest.getIsPending() ? "Pending" : ""));
            i++;
        }
        return i;
    }
    public void deleteRequest(IncomingTourRequest request){
        for( IncomingTourRequest touristRequest : incomingRequests){
            if((touristRequest.getRequestId() == request.getRequestId()) && (touristRequest.touristID == request.touristID)){
                incomingRequests.remove(touristRequest);
                return;
            }
        }
    }
    public IncomingTourRequest getRequestByIndex(int index){
        return incomingRequests.get(index);
    }

}
