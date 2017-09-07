package com.movit.service.impl;

import com.movit.dao.PersonMapper;
import com.movit.model.Person;
import com.movit.service.IPersonService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@CacheConfig(cacheNames = "person")
public class PersonServiceImpl implements IPersonService {
    @Resource
    private PersonMapper personMapper;


    public List<Person> findAll() {
        return personMapper.findAll();
    }

    @Cacheable(key = "#id")
    public Person getById(Integer id) {
        return personMapper.selectByPrimaryKey(id);
    }

    @CacheEvict(key = "#id")
    public boolean deleteById(Integer id) {
        return personMapper.deleteByPrimaryKey(id) > 0 ? true : false;
    }

    @CachePut(key = "#person.getId()")
    public Person insert(Person person) {
        int insert = personMapper.insert(person);
        if (insert > 0) {
            return person;
        }
        return null;
    }

    @CachePut(key = "#person.getId()")
    public Person update(Person person) {
        int update = personMapper.updateByPrimaryKey(person);
        if (update > 0) {
            return person;
        }
        return null;
    }
}
