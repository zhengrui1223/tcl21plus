package com.movit.service.impl;

import com.movit.annotation.Autowired;
import com.movit.annotation.Service;
import com.movit.dao.UserDao;
import com.movit.model.User;
import com.movit.service.IUserService;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserDao userDao;

    public List<User> getUserList() {

        return userDao.getUserList();
    }
}
