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
    public void addPendingRequest(TouristRequest touristRequest){
        allTourRequests.add(touristRequest);
    }




}
