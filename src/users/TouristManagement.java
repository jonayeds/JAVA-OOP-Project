package users;


import tourpackages.Package;

public class TouristManagement  {
    public double bookExistingPackage(Package selectedPackage , double paymentPending){
        return selectedPackage.packagePrice+paymentPending;
    }
}
