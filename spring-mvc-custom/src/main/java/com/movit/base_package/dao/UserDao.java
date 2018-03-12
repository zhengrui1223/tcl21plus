package com.movit.base_package.dao;

import com.movit.annotation.Repository;
import com.movit.base_package.model.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {

    public List<User> getUserList(String param) {
        List<User> users = new ArrayList<User>();
        users.add(new User(1, param, "123456"));
        return users;
    }
}
