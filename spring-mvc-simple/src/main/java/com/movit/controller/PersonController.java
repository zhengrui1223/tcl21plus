package com.movit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.movit.model.Person;
import com.movit.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class PersonController extends MultiActionController {
    private IPersonService personService;
    @Autowired
    private ObjectMapper defaultObjectMapper;
    private Integer index = 0;

    public void list(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Person> users = personService.findAll();
        PrintWriter writer = response.getWriter();
        writer.write(new ObjectMapper().writeValueAsString(users));
        writer.close();
    }

    public void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Person person = new Person();
        person.setName("test_insert_cache" + (index++));
        person.setPassword("password" + (index++));
        Person insert = personService.insert(person);

        PrintWriter writer = response.getWriter();
        writer.write(defaultObjectMapper.writeValueAsString(insert));
        writer.close();
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        Person person = new Person();
        person.setId(id);
        person.setName(name);
        person.setPassword(password);
        Person update = personService.update(person);

        PrintWriter writer = response.getWriter();
        writer.write(defaultObjectMapper.writeValueAsString(update));
        writer.close();
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        boolean success = personService.deleteById(id);

        PrintWriter writer = response.getWriter();
        writer.write(defaultObjectMapper.writeValueAsString(success ? "删除成功" : "删除失败"));
        writer.close();
    }

    public void getById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Person person = personService.getById(id);

        PrintWriter writer = response.getWriter();
        writer.write(defaultObjectMapper.writeValueAsString(person));
        writer.close();
    }


    public void setPersonService(IPersonService personService) {
        this.personService = personService;
    }

}
