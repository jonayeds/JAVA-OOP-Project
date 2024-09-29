package users;


import tourpackages.Package;

public class TouristManagement  {
    public double bookExistingPackage(Package selectedPackage , double paymentPending, int touristId){
        boolean isBooked = selectedPackage.isBooked(touristId);
//        System.out.println(isBooked + " " + touristId);
        if(!isBooked){
        selectedPackage.addToBookedBy(touristId);
        return selectedPackage.getPackagePrice()+paymentPending;
        }
        return paymentPending;
    }
}
