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

    public Person insert(Person person) {
        int insert = personMapper.insertSelective(person);
        if (insert >0) {
            return person;
        }
        return null;
    }

    public Person update(Person person) {
        int update = personMapper.updateByPrimaryKey(person);
        if (update >0) {
            return person;
        }
        return null;
    }
}
