package com.movit.service.impl;

import com.movit.dao.UserMapper;
import com.movit.model.User;
import com.movit.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by admin on 2017/2/5.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    public User getUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
