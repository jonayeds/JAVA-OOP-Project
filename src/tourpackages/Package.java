package tourpackages;
public  class Package{
    private int packageID;
    private String packageName;
    private String tourDestination;
    private double packagePrice;
    private int bookedBy[] = new int[4] ;

    public Package(int packageID, String packageName, String tourDestination, double packagePrice) {
        this.packageID=packageID;
        this.packageName=packageName;
        this.tourDestination=tourDestination;
        this.packagePrice=packagePrice;
    }
    public int getPackageID() {
        return packageID;
    }
    public String getPackageName() {
        return packageName;
    }
    public String getTourDestination() {
        return tourDestination;
    }
    public double getPackagePrice() {
        return packagePrice;
    }
    public void addToBookedBy(int touristId) {
        for(int i=0;i<bookedBy.length;i++){
            if(bookedBy[i]==touristId){
                break;
            }
            if(bookedBy[i] == 0){
                bookedBy[i] = touristId;
                break;
            }
        }
    }
}
