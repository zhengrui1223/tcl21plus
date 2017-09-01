package com.movit.controller;

import com.movit.model.User;
import com.movit.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * dispatcher-servlet.xml 必须激活@Controller模式
 */
@Controller
@RequestMapping("/user")
public class UserAnnotationController{
    @Autowired
    private IUserService userService;
    private Integer index = 0;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public List<User> list() throws IOException {
        List<User> users = userService.findAll();
        return users;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public User insert() throws IOException {
        User user = new User();
        user.setName("test_insert_cache" + (index++));
        user.setPassword("password" + (index++));
        User insert = userService.insert(user);
        return insert;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT)
    public User update(@RequestBody User user) throws IOException {
        User update = userService.update(user);
        return update;
    }

    @ResponseBody
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id) throws IOException {
        boolean success = userService.deleteById(id);
        return success ? "删除成功" : "删除失败";
    }

    @ResponseBody
    @RequestMapping(value = "/{id}" ,method = RequestMethod.GET)
    public User getById(@PathVariable("id") Integer id) throws IOException {
        User user = userService.getById(id);
        return user;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

}
