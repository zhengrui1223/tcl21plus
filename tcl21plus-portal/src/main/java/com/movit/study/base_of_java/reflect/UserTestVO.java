package com.movit.study.base_of_java.reflect;

/**
 * Created by admin on 2017/3/22.
 */
public class UserTestVO extends BaseUserTestVO{
    private String name;
    private int age;

    public UserTestVO() {
    }

    public UserTestVO(String name, int age) {

        this.name = name;
        this.age = age;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
