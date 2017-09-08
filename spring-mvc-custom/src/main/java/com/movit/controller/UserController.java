package com.movit.controller;

import com.movit.annotation.Autowired;
import com.movit.annotation.Controller;
import com.movit.model.User;
import com.movit.service.IUserService;

import java.util.List;

@Controller("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    public List<User> getUserList() {
        List<User> users = userService.getUserList();
        return users;
    }

}
