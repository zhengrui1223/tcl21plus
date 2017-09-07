package com.movit.dao;


import com.movit.model.Person;

import java.util.List;

public interface PersonMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Person record);

    Person selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(Person record);

    List<Person> findAll();
}