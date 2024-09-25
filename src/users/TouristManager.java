package users;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TouristManager  {
     public TouristManager(){
         touristList = new ArrayList<Tourist>();
     }
     protected List<Tourist> touristList;


     public void addTourist(Tourist tourist){
        touristList.add(tourist);
    }
    public void displayTourist(){
         for (Tourist tourist : touristList){
             System.out.println(tourist);
         }
    }
    public Tourist touristVerification(String email, String password){
         Tourist foundedTourist =null;
         for(Tourist tourist : touristList){
//             System.out.println(tourist.email instanceof String);
             if(Objects.equals(tourist.email, email) && Objects.equals(tourist.password, password)){
                 foundedTourist =  tourist;
             }
         }
         return foundedTourist;
    }
}
