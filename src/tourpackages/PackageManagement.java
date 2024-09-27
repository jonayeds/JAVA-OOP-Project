package tourpackages;

import java.util.ArrayList;
import java.util.List;

public class PackageManagement {
    public List<Package> packageList;
    public PackageManagement() {
        packageList = new ArrayList<Package>();
    }
    public void addPackage(Package p) {
        packageList.add(p);
    }
    public void displayPackages() {
        int idx =0;
        for (Package p : packageList) {
            idx++;
            System.out.println(idx + " --> "+p.packageName + " || "+ p.tourDestination+ " || "+ p.packagePrice);
        }
    }
    public Package getPackageByID(int id) {
        for (Package p : packageList) {
            if(p.packageID == id) {
                return p;
            }
        }
        return null;
    }
}
