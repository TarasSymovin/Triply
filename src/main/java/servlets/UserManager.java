package servlets;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> userList;

    public UserManager() {
        userList = new ArrayList<>();
        userList.add(new User(1, "Taras"));
        userList.add(new User(2, "Andrii"));
        userList.add(new User(3, "Nastya"));
    }

    public User getUserById(int id){
        for (User user : userList){
            if (user.getId() == id){
                return user;
            }
        }
        return null;
    }
}
