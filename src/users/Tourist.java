package users;

abstract class Tourist {
    private String name;
    private int id;
    private String password;
    private String email;

    public Tourist(String name, int id, String password, String email) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.email = email;
    }



}
