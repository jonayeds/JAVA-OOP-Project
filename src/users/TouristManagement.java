package users;


import tourpackages.Package;
import tourpackages.PackageManagement;

public class TouristManagement  {
    public void bookExistingPackage(Package selectedPackage , int paymentPending){
        System.out.println("Pending Payment : "+selectedPackage.packagePrice);

    }
}
