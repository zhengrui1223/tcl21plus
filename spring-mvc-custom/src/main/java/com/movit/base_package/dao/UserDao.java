package com.movit.base_package.dao;

import com.movit.annotation.Repository;
import com.movit.base_package.model.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {

    public List<User> getUserList() {
        List<User> users = new ArrayList<User>();
        users.add(new User(1, "jerry1", "123456"));
        users.add(new User(2, "jerry2", "123456"));
        users.add(new User(3, "jerry3", "123456"));
        return users;
    }
}
