package users;

public class Tourist extends UserTemplate {
    private double pendingPayment =0;
    public Tourist(String name, int id, String password, String email){
        super(name, id, password, email, "tourist");
    }

    public double getPendingPayment() {
        return pendingPayment;
    }
    public void setPendingPayment(double pendingPayment) {
        this.pendingPayment = pendingPayment;
    }




}
