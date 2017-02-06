package com.movit.service.impl;

import com.movit.dao.PersonMapper;
import com.movit.model.Person;
import com.movit.service.IPersonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by admin on 2017/2/6.
 */
@Service
public class PersonServiceImpl implements IPersonService {
    @Resource
    private PersonMapper personMapper;

    public List<Person> findAll() {
        return personMapper.findAll();
    }

    public Person getById(Integer id) {
        return personMapper.selectByPrimaryKey(id);
    }

    public boolean deleteById(Integer id) {
        return personMapper.deleteByPrimaryKey(id) > 0 ? true : false;
    }

    public boolean insert(Person obj) {
        return personMapper.insertSelective(obj) > 0 ? true : false;
    }

    public boolean update(Person obj) {
        return personMapper.updateByPrimaryKey(obj) > 0 ? true : false;
    }
}
