package users;

abstract class UserTemplate {
    protected String name;
    protected int id;
    protected String password;
    protected String email;
    public String role;

    public UserTemplate(String name,  String password, String email, String role) {
        this.name = name;
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
    public String getEmail() {
        return email;
    }
    public void setId(int id){
        this.id = id;
    }
        @Override
    public String toString(){
        return  "User name: " + name + " id: " + id + " password: " + password + " email: " + email;
    }
}
