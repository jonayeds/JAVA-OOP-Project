package tourpackages;
public  class Package{
    private int packageID;
    private  String packageName;
    private  String tourDestination;
    private  double packagePrice;
    private  int[] bookedBy = new int[4] ;

    public Package( String packageName, String tourDestination, double packagePrice) {
        this.packageName=packageName;
        this.tourDestination=tourDestination;
        this.packagePrice=packagePrice;
    }
    public int getPackageID() {
        return packageID;
    }
    public void setPackageId(int id){
        this.packageID=id;
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
            if(bookedBy[i] == 0){
                bookedBy[i] = touristId;
                return;
            }
        }

    }
    public int[] getBookedBy() {
        return bookedBy;
    }
    public boolean isBooked(int touristId){
        for (int j : bookedBy) {
            if (j == touristId) {
                System.out.println("Already Booked this package!!");
                return true;
            }
        }
        return false;
    }
    public boolean isConfirmed(){
        for (int i : bookedBy) {
            if (i == 0) {
                return false;
            }
        }

        return true;
    }
}
