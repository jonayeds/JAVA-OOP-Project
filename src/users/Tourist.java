package users;

public class Tourist extends UserTemplate {
    private double pendingPayment =0;
    public Tourist(String name, String password, String email){
        super(name,  password, email, "tourist");
    }

    public double getPendingPayment() {
        return pendingPayment;
    }
    public void setPendingPayment(double pendingPayment) {
        this.pendingPayment = pendingPayment;
    }




}
