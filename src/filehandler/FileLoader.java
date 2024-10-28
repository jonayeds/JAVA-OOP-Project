package filehandler;

import tourpackages.Package;
import tourpackages.PackageManagement;
import users.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class FileLoader {


    public void readTouristData(UserManagement userManagement){
        String touristFile = System.getProperty("user.dir")+ "\\data\\tourists.csv";
        try{
            BufferedReader reader = new BufferedReader(new FileReader(touristFile));
            String  line;
            while((line=reader.readLine())!= null){
                String[] data  = line.split(",");
                if(data[0].equals("Name"))continue;
                Tourist tourist = new Tourist(data[0], data[1], data[2]);
                tourist.setPendingPayment(Double.parseDouble(data[3]));
                if(!Objects.equals(data[5], "n")){
                    String[] tourRequest = data[5].split("!");
//                Loop through each tourist request data
                for(String req : tourRequest){
                    if(req.isEmpty()) break;
                    String[] reqData = req.split("-");
                    if(reqData.length == 1) break;
                    TouristRequest request = new TouristRequest(reqData[0], Double.parseDouble(reqData[1]));
                    request.setIsPending(Boolean.parseBoolean(reqData[2]));
                    request.setIsRejected(Boolean.parseBoolean(reqData[3]));
                    tourist.addTourRequest(request);
                    userManagement.sendRequestToAdmin(request, Integer.parseInt(data[4]), data[0], data[1]);
                }
                }

                userManagement.addTourist(tourist);

            }
        }catch (IOException e){
            System.out.println("Error while reading Tourist Data");
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
            System.out.println("Error while reading Admin Data");
        }
    }

    public void readPackageData(PackageManagement packageManagement){
        String packageFile = System.getProperty("user.dir") + "\\data\\packages.csv";
        try{
            BufferedReader reader = new BufferedReader(new FileReader(packageFile));
            String  line;
            while((line=reader.readLine())!= null){
                String[] data  = line.split(",");
                if(data[0].equals("packageName"))continue;
                Package pack = new Package(data[0], data[1], Double.parseDouble(data[2]));
                packageManagement.addPackage(pack);
                String[] bookedBy = data[3].split("-");
                for(String tourist : bookedBy){
                    if(Integer.parseInt(tourist) == 0) break;
                    pack.addToBookedBy(Integer.parseInt(tourist));
                }
                if(Integer.parseInt(bookedBy[3]) != 0) packageManagement.handleConfirmedPackage(pack);

            }

        }catch (IOException e){
            System.out.println("Error while reading Package Data");
        }
    }

    public void readConfirmedPackages(PackageManagement packageManagement){
        String confirmedFile = System.getProperty("user.dir")+ "\\data\\confirmedPackages.csv";
        try{
            BufferedReader reader = new BufferedReader(new FileReader(confirmedFile));
            String line;
            while((line=reader.readLine())!= null){
                String[] data = line.split(",");
                if(data[0].equals("packageName"))continue;
                Package pack = new Package(data[0], data[1], Double.parseDouble(data[2]));
                String[] bookedBy = data[3].split("-");
                for(String tourist : bookedBy){
                    pack.addToBookedBy(Integer.parseInt(tourist));
                }
                packageManagement.handleConfirmedPackage(pack);
            }
        }catch (IOException e){
            System.out.println("Error while reading ConfirmedPackages Data");
        }
    }



}
