package users;

public class Admin extends UserTemplate {

    public Admin(String name, int id, String password, String email){
        super(name,id,password,email,"admin");
    }

}
