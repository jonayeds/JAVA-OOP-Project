package users;

public class UserTemplate {
    protected String name;
    protected int id;
    protected String password;
    protected String email;

    public UserTemplate(String name, int id, String password, String email) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.email = email;
    }
    @Override
    public String toString(){
        return  "User name: " + name + " id: " + id + " password: " + password + " email: " + email;
    }
}
