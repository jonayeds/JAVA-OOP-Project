package users;

import java.util.ArrayList;
import java.util.List;

 public class TouristManager  {
     public TouristManager(){
         touristList = new ArrayList<Tourist>();
     }
     private List<Tourist> touristList;


     public void addTourist(Tourist tourist){
        touristList.add(tourist);
    }
    public void displayTourist(){
         for (Tourist tourist : touristList){
             System.out.println(tourist);
         }
    }
}
