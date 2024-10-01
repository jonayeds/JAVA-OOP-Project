package tourpackages;

import java.util.ArrayList;
import java.util.List;

public class PackageManagement {
    public List<Package> packageList;
    public PackageManagement() {
        packageList = new ArrayList<Package>();
    }
    public void addPackage(Package p) {
        System.out.println("number of packages "+packageList.size());
        packageList.add(p);
    }
    public void displayPackages() {
        int idx =0;
        for (Package p : packageList) {
            idx++;
            System.out.println(idx + " --> "+p.getPackageName() + " || "+ p.getTourDestination()+ " || "+ p.getPackagePrice());
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
}
