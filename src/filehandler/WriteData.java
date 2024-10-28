package filehandler;

import tourpackages.Package;
import users.Admin;
import users.Tourist;
import users.TouristRequest;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

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
            System.out.println("Error writing to tourist file");
        }
    }

//    public void writeAdminData(ArrayList<Admin> adminList){
//        String adminFile = System.getProperty("user.dir") + "\\data\\admin.csv";
//        try{
//            FileWriter writer  = new FileWriter(adminFile);
//            for(Admin admin : adminList){
//                writer.append(admin.getName()+","+admin.getPassword()+","+admin.getEmail()+","+admin.getId()+"\n");
//            }
//            writer.close();
//        }catch(IOException e){
//            System.out.println("Error writing to admin file");
//        }
//    }

    public void writePackageData(ArrayList<Package> packageList){
        String packageFile = System.getProperty("user.dir") + "\\data\\packages.csv";
        try{
            FileWriter writer  = new FileWriter(packageFile);
            writer.append("Package Name, Tour Destination, Price, Booked by\n");
            for(Package pack : packageList){
                String bookedBy= "";
                for( int i=0 ; i<pack.getBookedBy().length; i++){
                    bookedBy+= pack.getBookedBy()[i];
                    if(i<pack.getBookedBy().length-1){
                        bookedBy+="-";
                    }
                }
                writer.append(pack.getPackageName()+","+pack.getTourDestination()+","+pack.getPackagePrice()+","+bookedBy+"\n");
            }
            writer.close();
        }catch(IOException e){
            System.out.println("Error writing to packages file");
        }
    }

    public void writeConfirmedPackages(ArrayList<Package> confirmedPackageList){
        String confirmedFile = System.getProperty("user.dir") + "\\data\\confirmedPackages.csv";
        try{
            FileWriter writer = new FileWriter(confirmedFile);
            writer.append("Package Name, Tour Destination, Price, Booked by\n");
            for(Package pack : confirmedPackageList){
                String bookedBy="";
                for(int i=0; i<pack.getBookedBy().length; i++){
                    bookedBy+= pack.getBookedBy()[i];
                    if(i<pack.getBookedBy().length-1){
                        bookedBy+="-";
                    }
                }
                writer.append(pack.getPackageName()+","+pack.getTourDestination()+","+pack.getPackagePrice()+","+bookedBy+"\n");
            }
            writer.close();

        }catch (IOException e){
            System.out.println("Error writing to Confirmed Packages file");
        }
    }
}
