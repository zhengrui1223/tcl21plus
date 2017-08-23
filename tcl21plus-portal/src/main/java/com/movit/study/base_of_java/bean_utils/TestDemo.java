package com.movit.study.base_of_java.bean_utils;

import org.springframework.beans.BeanUtils;

/**
 * Created by Administrator on 2017/3/2.
 */
public class TestDemo {
    public static void main(String [] args){
        Student student = new Student();
        student.setFirstName("hehh");
        student.setLastName("fdsf");
        student.setAge(21);

        Person person = new Person();

        BeanUtils.copyProperties(student, person);

        System.out.println(person.getFirstName()+ "###" + person.getLastName());

    }
}
