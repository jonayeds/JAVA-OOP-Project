package users;


import tourpackages.Package;
import tourpackages.PackageManagement;

public class TouristManagement  {
    public double bookExistingPackage(Package selectedPackage , double paymentPending, int touristId, PackageManagement packageManagement){
        boolean isBooked = selectedPackage.isBooked(touristId);


        if(!isBooked){
        selectedPackage.addToBookedBy(touristId);
        return selectedPackage.getPackagePrice()+paymentPending;
        }
        boolean isConfirmed  = selectedPackage.isConfirmed();
        if(isConfirmed){
            System.out.println("hittt");
            packageManagement.handleConfirmedPackage(selectedPackage);
        }
        return paymentPending;
    }
}
