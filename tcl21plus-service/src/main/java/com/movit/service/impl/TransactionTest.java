package com.movit.service.impl;

import com.movit.dao.PersonMapper;
import com.movit.dao.UserMapper;
import com.movit.model.Person;
import com.movit.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by admin on 2017/2/6.
 */
@Service
public class TransactionTest {
    @Resource
    private UserMapper userMapper;
    @Resource
    private PersonMapper personMapper;

    public boolean insert(User user, Person person) {

        int success = userMapper.insert(user);

        if (success > 0) {
            success = personMapper.insert(person);
            if (success > 0) {
                return true;
            }
        }
        return false;
    }
}
