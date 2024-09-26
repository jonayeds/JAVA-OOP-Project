package tourpackages;
public  class Package{
    protected int packageID;
    protected String packageName;
    protected String tourDestination;
    protected double packagePrice;

    public Package(int packageID, String packageName, String tourDestination, double packagePrice) {
        this.packageID=packageID;
        this.packageName=packageName;
        this.tourDestination=tourDestination;
        this.packagePrice=packagePrice;
    }
}
