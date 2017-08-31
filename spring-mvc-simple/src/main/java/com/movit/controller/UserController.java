package com.movit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.movit.model.User;
import com.movit.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UserController extends MultiActionController {
    private IUserService userService;
    @Autowired
    private ObjectMapper defaultObjectMapper;
    private Integer index = 0;

    public void list(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<User> users = userService.findAll();
        PrintWriter writer = response.getWriter();
        writer.write(new ObjectMapper().writeValueAsString(users));
        writer.close();
    }

    public void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = new User();
        user.setName("test_insert_cache" + (index++));
        user.setPassword("password" + (index++));
        User insert = userService.insert(user);

        PrintWriter writer = response.getWriter();
        writer.write(defaultObjectMapper.writeValueAsString(insert));
        writer.close();
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);
        User update = userService.update(user);

        PrintWriter writer = response.getWriter();
        writer.write(defaultObjectMapper.writeValueAsString(update));
        writer.close();
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        boolean success = userService.deleteById(id);

        PrintWriter writer = response.getWriter();
        writer.write(defaultObjectMapper.writeValueAsString(success ? "删除成功" : "删除失败"));
        writer.close();
    }

    public void getById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        User user = userService.getById(id);

        PrintWriter writer = response.getWriter();
        writer.write(defaultObjectMapper.writeValueAsString(user));
        writer.close();
    }


    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

}
