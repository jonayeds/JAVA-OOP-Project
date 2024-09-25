package users;

abstract class TouristTemplate {
    private String name;
    private int id;
    private String password;
    private String email;

    public TouristTemplate(String name, int id, String password, String email) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.email = email;
    }
    @Override
    public String toString(){
        return  "Tourist name: " + name + " id: " + id + " password: " + password + " email: " + email;
    }
}
