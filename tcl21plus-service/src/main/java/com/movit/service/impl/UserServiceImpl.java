package com.movit.service.impl;

import com.google.code.ssm.api.ParameterValueKeyProvider;
import com.google.code.ssm.api.ReadThroughAssignCache;
import com.google.code.ssm.api.ReadThroughSingleCache;
import com.movit.dao.UserMapper;
import com.movit.model.User;
import com.movit.service.IUserService;
import com.movit.utils.Context;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by admin on 2017/2/5.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    public List<User> findAll() {
        return userMapper.findAll();
    }

    @ReadThroughSingleCache( namespace = Context.USER_INFO , expiration = 3600)
    public User getById(@ParameterValueKeyProvider Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public boolean deleteById(Integer id) {
        return userMapper.deleteByPrimaryKey(id) > 0 ? true : false;
    }

    public boolean insert(User obj) {
        return userMapper.insertSelective(obj) > 0 ? true : false;
    }

    public boolean update(User obj) {
        return userMapper.updateByPrimaryKey(obj) > 0 ? true : false;
    }
}
