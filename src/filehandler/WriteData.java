package filehandler;

import users.Tourist;
import users.TouristRequest;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteData {
    public void writeTourist(ArrayList<Tourist> touristList){
        String touristFile = System.getProperty("user.dir") + "\\data\\tourists.csv";
        try{
            FileWriter writer = new FileWriter(touristFile);
            writer.append( "Name,password,email,PendingPayment,TouristId,TourRequest\n");
            for(Tourist tourist : touristList){
                if(tourist.getAllTourRequests().isEmpty()){
                    writer.append(tourist.getName()+","+tourist.getPassword()+","+tourist.getEmail()+","+tourist.getPendingPayment()+","+tourist.getId()+",n\n");
                }
                else {
                    String tourRequests ="";
                    for(TouristRequest request : tourist.getAllTourRequests()){
                        tourRequests+= request.getDestination()+"-"+request.getBudget()+"-"+request.getIsPending()+"-"+request.getIsRejected()+"-"+"!";
                    }
                        writer.append(tourist.getName()+","+tourist.getPassword()+","+tourist.getEmail()+","+tourist.getPendingPayment()+","+tourist.getId()+","+tourRequests+"\n");

                }
            }
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
