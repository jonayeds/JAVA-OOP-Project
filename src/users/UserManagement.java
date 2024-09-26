package users;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserManagement {

    protected List<UserTemplate> userList;

    public UserManagement(){
        userList = new ArrayList<UserTemplate>();
    }

    public UserTemplate userVerification(String email, String password){
        for(UserTemplate user : userList){
            if(Objects.equals(email, user.email) && Objects.equals(password, user.password)){
                return user;
            }
        }
        return null;
    }
    public void addUser(UserTemplate user){
        userList.add(user);
    }
}
