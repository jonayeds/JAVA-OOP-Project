package tourpackages;

import java.util.ArrayList;
import java.util.List;

public class PackageManagement {
    List<Package> packageList;
    public PackageManagement() {
        packageList = new ArrayList<Package>();
    }
    public void addPackage(Package p) {
        packageList.add(p);
    }
    public void displayPackages() {
        for (Package p : packageList) {
            System.out.println(p.packageName + " || "+ p.tourDestination+ " || "+ p.packagePrice);
        }
    }
}
