package tourpackages;

import java.util.ArrayList;
import java.util.List;

public class PackageManagement {
    private List<Package> packageList;
    public PackageManagement() {
        packageList = new ArrayList<Package>();
    }
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
    public Package getPackageByID(int id) {
        for (Package p : packageList) {
            if(p.getPackageID() == id) {
                return p;
            }
        }
        return null;
    }
    public void deletePackage(int chosenPackage) {
        int temp=0;
        int packageId = packageList.get(chosenPackage-1).getPackageID();
        for(int i=0; i<packageList.size(); i++) {
            if(packageList.get(i).getPackageID() == packageId) {
                packageList.remove(packageList.get(i));
                break;
            }
        }
    }
}
