package com.movit.controller;

import com.movit.model.Person;
import com.movit.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * dispatcher-servlet.xml 必须激活@Controller模式
 */
@Controller
@RequestMapping("/person")
public class PersonAnnotationController {
    @Autowired
    private IPersonService personService;
    private Integer index = 0;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public List<Person> list() throws IOException {
        List<Person> persons = personService.findAll();
        return persons;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public Person insert() throws IOException {
        int temp = index++;
        Person person = new Person();
        person.setName("test_insert_cache" + temp);
        person.setPassword("password" + temp);
        Person insert = personService.insert(person);
        return insert;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT)
    public Person update(@RequestBody Person person) throws IOException {
        Person update = personService.update(person);
        return update;
    }

    @ResponseBody
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id) throws IOException {
        boolean success = personService.deleteById(id);
        return success ? "删除成功" : "删除失败";
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person getById(@PathVariable("id") Integer id) throws IOException {
        Person person = personService.getById(id);
        return person;
    }

    public void setUserService(IPersonService personService) {
        this.personService = personService;
    }

}
