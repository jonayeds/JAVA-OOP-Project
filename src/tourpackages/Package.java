package tourpackages;
public  class Package{
    protected int packageID;
    public String packageName;
    public String tourDestination;
    public double packagePrice;
    int bookedBy=0;

    public Package(int packageID, String packageName, String tourDestination, double packagePrice) {
        this.packageID=packageID;
        this.packageName=packageName;
        this.tourDestination=tourDestination;
        this.packagePrice=packagePrice;
    }
}
