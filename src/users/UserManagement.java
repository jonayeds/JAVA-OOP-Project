package users;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserManagement {

    protected List<Tourist> touristList;
    protected List<Admin> adminList;
    public UserManagement(){
        touristList = new ArrayList<Tourist>();
        adminList = new ArrayList<Admin>();
    }

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

    public void addTourist(Tourist tourist){
        tourist.setId(touristList.size()+1);
        touristList.add(tourist);
        System.out.println("Tourist added"+ touristList.size());
    }
    public void addAdmin(Admin admin){
        admin.setId(adminList.size()+1);
        adminList.add(admin);
    }
}
