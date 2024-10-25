package users;

import java.util.ArrayList;
import java.util.Objects;

public class UserManagement {

    protected ArrayList<Tourist> touristList = new ArrayList<>();
    protected ArrayList<Admin> adminList = new ArrayList<>();

    public Tourist getTourist(String email, String password){
        Tourist tourist = null;
        for(Tourist user : touristList){
            if(Objects.equals(email, user.email) && Objects.equals(password, user.password)){
                tourist = user;
                break;
            }
        }
        return tourist;
    }

    public Admin getAdmin(String email, String password){
        Admin admin = null;
        for(Admin user : adminList){
            if(Objects.equals(email, user.email) && Objects.equals(password, user.password)){
                admin = user;
                break;
            }
        }
        return admin;
    }


    public String userVerification(String email, String password){
        for(Tourist user : touristList){
            if(Objects.equals(email, user.email) && Objects.equals(password, user.password)){
                return "tourist";
            }
        }
        for(Admin user : adminList){
            if(Objects.equals(email, user.email) && Objects.equals(password, user.password)){
                return "admin";
            }
        }
        return null;
    }

    public void reducePendingPayment(int userId, double cost){
        for(Tourist user : touristList){
            if(user.id == userId){
                user.setPendingPayment(user.getPendingPayment()- cost);
            }
        }
    }
    public void sendRequestToAdmin(TouristRequest request, int touristId, String touristName, String touristEmail){
        for(Admin admin : adminList){
            admin.addRequest(request, touristId, touristName, touristEmail);
        }
    }
    public void handleRequest(boolean isRejected , IncomingTourRequest request){
        for(Tourist tourist : touristList){
            if(tourist.getId() == request.touristID){
                System.out.println("Tourist Found");
                for(TouristRequest req : tourist.getAllTourRequests()){
                    System.out.println(req.getRequestId() +" vs "+ request.getRequestId());
                    if(req.getRequestId() ==  request.getRequestId()){
                        System.out.println("Request Found");
                        req.setIsRejected(isRejected);
                        req.setIsPending(false);
                        return;
                    }
                }

            }
        }
    }

    public void addTourist(Tourist tourist){
        tourist.setId(touristList.size()+1);
        touristList.add(tourist);
    }
    public void addAdmin(Admin admin){
        admin.setId(adminList.size()+1);
        adminList.add(admin);
    }

}
