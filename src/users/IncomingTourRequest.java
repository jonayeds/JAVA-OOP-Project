package users;

public class IncomingTourRequest extends TouristRequest {
    int touristID;
    String touristName;
    String touristEmail;
    public IncomingTourRequest(String destination, double budget, int touristID, String touristName, String touristEmail) {
        super(destination,budget);
        this.touristID = touristID;
        this.touristName = touristName;
        this.touristEmail = touristEmail;
    }
}
