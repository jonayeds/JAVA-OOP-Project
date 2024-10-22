package users;


import tourpackages.Package;
import tourpackages.PackageManagement;

public class TouristManagement  {
    public double bookExistingPackage(Package selectedPackage , double paymentPending, int touristId, PackageManagement packageManagement){
        boolean isBooked = selectedPackage.isBooked(touristId);
        double pending = paymentPending;
        if(!isBooked){
            selectedPackage.addToBookedBy(touristId);
            pending =  selectedPackage.getPackagePrice()+paymentPending;
        }
        boolean isConfirmed  = selectedPackage.isConfirmed();
        if(isConfirmed){
            packageManagement.handleConfirmedPackage(selectedPackage);
        }
        return pending;
    }
}
