package tourpackages;

import users.UserManagement;

import java.util.ArrayList;
import java.util.List;

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
        System.out.println();
        for (Package p : packageList) {
            idx++;
            System.out.println(idx + " --> "+p.getPackageName() + " || "+ p.getTourDestination()+ " || "+ p.getPackagePrice() +" || "+ p.getPackageID() );
        }
    }
    public void displayConfirmedPackages() {
        int idx =0;
        System.out.println();
        for (Package p : confirmedPackageList) {
            idx++;
            System.out.println(idx + " --> "+p.getPackageName() + " || "+ p.getTourDestination()+ " || "+ p.getPackagePrice() +" || "+ p.getPackageID() );
        }
    }

    public Package getPackageByID(int id) {
        for (Package p : packageList) {
            if(p.getPackageID() == id) {
                return p;
            }
        }
        return null;
    }
    public Package getPackageByIndex(int index){
        return packageList.get(index);
    }
    public void deletePackage(Package chosenPackage, UserManagement userManagement) {
        int temp=0;
        int packageId = chosenPackage.getPackageID();
        double packageCost = chosenPackage.getPackagePrice();
        int[] bookedBy = chosenPackage.getBookedBy();
        for(int i=0; i<bookedBy.length; i++){
            userManagement.reducePendingPayment(bookedBy[i], packageCost);
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
        for(int i=0; i<packageList.size(); i++){
            System.out.println( i+1 + " --> "+ packageList.get(i).getTourDestination());
            tourDestinations[i] = packageList.get(i).getTourDestination();
        }

        return tourDestinations;
    }


}
