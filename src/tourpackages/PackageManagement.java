package tourpackages;

import users.UserManagement;

import java.util.ArrayList;
import java.util.Arrays;

public class PackageManagement {
    private ArrayList<Package> packageList = new ArrayList<>();
    private ArrayList<Package> confirmedPackageList = new ArrayList<>();

    public void addPackage(Package p) {
        if(packageList.size()>0){
            int id = packageList.getLast().getPackageID();
            p.setPackageId(id+1);
        }else{
            p.setPackageId(1);
        }
        packageList.add(p);
    }
    public void displayPackages() {
        int idx =0;
        for (Package p : packageList) {
            idx++;
            System.out.println("\t\t"+idx + " --> "+p.getPackageName() + " || "+ p.getTourDestination()+ " || "+ p.getPackagePrice()+"$"  );
        }
        System.out.println("\t\t-----------------------------------------------------");
    }
    public void displayConfirmedPackages(UserManagement userManagement) {
        int idx =0;
        System.out.println("\t\t----------------------------- C O N F I R M E D   P A C K A G E S ----------------------------");
        for (Package p : confirmedPackageList) {
            idx++;
            String bookedBy =" Booked by: { ";
            for(int t =0;  t<p.getBookedBy().length;t++){
                bookedBy+= userManagement.getTouristById(p.getBookedBy()[t]).getName()+ (t==p.getBookedBy().length-1? " }" :" --&-- ");
            }
            System.out.println("\t\t"+idx + " --> "+p.getPackageName() + " || "+ p.getTourDestination()+ " || "+ p.getPackagePrice() +" || "+ p.getPackageID()+" || "+ bookedBy);
        }
    }

//    public Package getPackageByID(int id) {
//        for (Package p : packageList) {
//            if(p.getPackageID() == id) {
//                return p;
//            }
//        }
//        return null;
//    }
    public Package getPackageByIndex(int index){
        return packageList.get(index);
    }
    public void deletePackage(Package chosenPackage, UserManagement userManagement) {
        int packageId = chosenPackage.getPackageID();
        double packageCost = chosenPackage.getPackagePrice();
        int[] bookedBy = chosenPackage.getBookedBy();
        for (int j : bookedBy) {
            userManagement.reducePendingPayment(j, packageCost);
        }
        for(int i=0; i<packageList.size(); i++) {
            if(packageList.get(i).getPackageID() == packageId) {
                packageList.remove(packageList.get(i));
                break;
            }
        }
    }
    public void handleConfirmedPackage(Package p) {
        confirmedPackageList.add(p);
        packageList.removeIf(p1 -> p1.getPackageID() == p.getPackageID());

    }
    public String[] showTourDestinations(){
        String[] tourDestinations = new String[packageList.size()];
        System.out.println("\t\t-----Destinations-----");
        for(int i=0; i<packageList.size(); i++){
            System.out.println("\t\t"+ (i+1) + " --> "+ packageList.get(i).getTourDestination());
            tourDestinations[i] = packageList.get(i).getTourDestination();
        }
        System.out.println("\t\t--------------------");
        return tourDestinations;
    }
    public ArrayList<Package> getPackageList() {return packageList;}
    public ArrayList<Package> getConfirmedPackageList() {return confirmedPackageList;}


}
