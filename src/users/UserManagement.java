package users;

import filehandler.WriteData;

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
                System.out.println("Tourist found");
                for(TouristRequest req : tourist.getAllTourRequests()){
                    if(req.getRequestId() ==  request.getRequestId()){
                        System.out.println("Request found");
                        req.setIsRejected(isRejected);
                        req.setIsPending(false);
                        return;
                    }
                }

            }
        }
    }

    public boolean validateEmail(String email){
        String emailRegex = "^[a-z0-9]+(\\.[a-z0-9]+)*@[a-z]{2,7}\\.[a-z]{2,3}(\\.[a-z]{2,3})*$";
        return email.matches(emailRegex);
    }

    public boolean validatePassword(String password){
        String allowedCharacters = "[a-zA-Z0-9~!@#$%^&*/()\\.]*";
        boolean isValid = true;
        if(password.length() < 6) return false;
        if(!password.matches("^"+ allowedCharacters+ "[a-z]+"+ allowedCharacters +"$")) return false;
        if(!password.matches("^"+ allowedCharacters+ "[0-9]+"+ allowedCharacters +"$")) return false;
        if(!password.matches("^"+ allowedCharacters+ "[A-Z]+"+ allowedCharacters +"$")) return false;
        if(!password.matches("^"+ allowedCharacters+ "[~!@#$%^&*/()\\.]+"+ allowedCharacters +"$")) return false;
        return true;
    }

    public void addTourist(Tourist tourist){
        tourist.setId(touristList.size()+1);
        touristList.add(tourist);
    }
    public void addAdmin(Admin admin){
        admin.setId(adminList.size()+1);
        adminList.add(admin);
    }
    public ArrayList<Tourist> getAllTourists(){
        return touristList;
    }
    public ArrayList<Admin> getAllAdmins(){
        return adminList;
    }

}
