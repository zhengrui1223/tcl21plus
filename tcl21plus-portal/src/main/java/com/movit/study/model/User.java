package com.movit.study.model;

/**
 * Created by admin on 2016/11/27.
 */
public class User {
    private Integer id;
    private String name;
    private String passWord;
    private Person person;

    public User(){}

    public User(Integer id, String name, String passWord){
        this.id = id;
        this.name = name;
        this.passWord = passWord;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
