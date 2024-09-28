package users;


import tourpackages.Package;

public class TouristManagement  {
    public double bookExistingPackage(Package selectedPackage , double paymentPending, int touristId){
        selectedPackage.addToBookedBy(touristId);
        return selectedPackage.getPackagePrice()+paymentPending;
    }
}
