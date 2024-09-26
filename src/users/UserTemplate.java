package users;

public class UserTemplate {
    protected String name;
    protected int id;
    protected String password;
    protected String email;
    public String role;

    public UserTemplate(String name, int id, String password, String email, String role) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public String getName() {
        return name;
    }
    public int getId(){
        return id;
    }
        @Override
    public String toString(){
        return  "User name: " + name + " id: " + id + " password: " + password + " email: " + email;
    }
}
