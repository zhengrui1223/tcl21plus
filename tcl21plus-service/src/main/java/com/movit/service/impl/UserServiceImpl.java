package com.movit.service.impl;

import com.movit.dao.UserMapper;
import com.movit.model.User;
import com.movit.model.base.BaseEntity;
import com.movit.service.IUserService;
import com.movit.service.impl.base.BaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl extends BaseService implements IUserService {

    @Resource
    private UserMapper userMapper;

    private static final String PREFIX_USER_KEY = "USER_INFO_";
    private static final String PREFIX_USER_KEY_ALL = "USER_INFO_*";

    public List<User> findAll() {

        List<User> users = new ArrayList<User>();
        findAllEntityInCacheByPrefix(PREFIX_USER_KEY_ALL, users);
        if (users != null && !users.isEmpty()) {
            return users;
        }

        return userMapper.findAll();
    }

    public User getById(Integer id) {
        User user = (User) queryEntityFromCache(PREFIX_USER_KEY + id);
        if (user != null) {
            return user;
        }
        return userMapper.selectByPrimaryKey(id);
    }

    public boolean deleteById(Integer id) {
        boolean success = userMapper.deleteByPrimaryKey(id) > 0 ? true : false;
        if (success) {
            deleteEntityInCache(PREFIX_USER_KEY + id);
        }
        return success;
    }

    public User insert(User user) {
        int insert = userMapper.insert(user);
        if (insert >0) {
            updateEntity2Cache(PREFIX_USER_KEY, user);
            return user;
        }
        return null;
    }

    public User update(User user) {
        int update = userMapper.updateByPrimaryKey(user);
        if (update >0) {
            updateEntity2Cache(PREFIX_USER_KEY, user);
            return user;
        }
        return null;
    }

}
