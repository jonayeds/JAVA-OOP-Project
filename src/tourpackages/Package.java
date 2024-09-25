package tourpackages;
abstract  class Package{
    private int packageID;
    private String packageName;
    private String tourDestination;
    private double packagePrice;

    public Package(int packageID, String packageName, String tourDestination, double packagePrice) {
        this.packageID=packageID;
        this.packageName=packageName;
        this.tourDestination=tourDestination;
        this.packagePrice=packagePrice;
    }
}
