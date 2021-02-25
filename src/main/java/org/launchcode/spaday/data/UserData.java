package org.launchcode.spaday.data;

import org.launchcode.spaday.models.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// bonus
public class UserData {
    private  static List<User> users = new ArrayList<User>();
    public static void addUser(User user){
       users.add(user);
    }
    public static Collection<User> getAll(){return users;}
    public static User getById(int id) {
        for(User user : users){
            if(user.getId() == id)
                return user;
        }
        return null;

    }

//    public static void remove(Integer id) {
//        if (users.contains(id)) {
//            users.remove(id);
//        }
//    }
}
