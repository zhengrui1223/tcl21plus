package com.movit.study.controller;

import com.movit.model.User;
import com.movit.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by admin on 2016/11/27.
 */
@RestController("/testUser")
public class RestedController {
    @Autowired
    private IUserService userService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUser(){
        return userService.findAll();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public User getUserById(@PathVariable("id") String id){
        return userService.getById(Integer.parseInt(id));
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public boolean insertUser(@RequestBody User user){
        return userService.insert(user);
    }

    @RequestMapping(method = RequestMethod.PUT, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public boolean updateUser(@RequestBody User user){
        return userService.update(user);
    }
}
