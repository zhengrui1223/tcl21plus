package com.movit.base_package.service;

import com.movit.annotation.Autowired;
import com.movit.annotation.Service;
import com.movit.base_package.dao.UserDao;
import com.movit.base_package.model.User;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> getUserList(String param) {

        return userDao.getUserList(param);
    }
}
