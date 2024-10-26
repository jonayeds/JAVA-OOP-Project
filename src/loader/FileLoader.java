package loader;

import users.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileLoader {


    public void readTouristData(UserManagement userManagement){
        String touristFile = System.getProperty("user.dir")+ "\\data\\tourists.csv";
        try{
            BufferedReader reader = new BufferedReader(new FileReader(touristFile));
            String  line;
            while((line=reader.readLine())!= null){
                String[] data  = line.split(",");
                if(data[0].equals("name"))continue;
                Tourist tourist = new Tourist(data[0], data[1], data[2]);
                tourist.setPendingPayment(Double.parseDouble(data[3]));
                String[] tourRequest = data[5].split("!");

//                Loop through each tourist request data
                for(String req : tourRequest){
                    String[] reqData = req.split("-");
                    TouristRequest request = new TouristRequest(reqData[0], Double.parseDouble(reqData[1]));
                    request.setIsPending(Boolean.parseBoolean(reqData[2]));
                    request.setIsRejected(Boolean.parseBoolean(reqData[3]));
//                    request.setRequestId(Integer.parseInt(reqData[4]));
                    tourist.addTourRequest(request);
                    userManagement.sendRequestToAdmin(request, Integer.parseInt(data[4]), data[0], data[1]);
                }
                userManagement.addTourist(tourist);

            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void readAdminData(UserManagement userManagement){
        String adminFile = System.getProperty("user.dir")+ "\\data\\admin.csv";
        try{
            BufferedReader reader = new BufferedReader(new FileReader(adminFile));
            String  line;
            while((line=reader.readLine())!= null){
                String[] data  = line.split(",");
                if(data[0].equals("name"))continue;
                Admin admin = new Admin(data[0], data[1], data[2]);
                userManagement.addAdmin(admin);

            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }



}
