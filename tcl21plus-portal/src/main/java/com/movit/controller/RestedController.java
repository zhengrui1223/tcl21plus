package com.movit.controller;

import com.movit.model.User;
import com.movit.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by admin on 2016/11/27.
 */
@RestController
@RequestMapping("/testUser")
public class RestedController {
    @Autowired
    private IUserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAllUser(){
        return userService.findAll();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") String id){
        return userService.getById(Integer.parseInt(id));
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public User insertUser(@RequestBody User user){
        return userService.insert(user);
    }

    @RequestMapping(method = RequestMethod.PUT, produces = "application/json")
    public User updateUser(@RequestBody User user){
        return userService.update(user);
    }
}
