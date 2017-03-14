package com.movit.service.impl;

import com.google.code.ssm.api.ParameterValueKeyProvider;
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

    /**
     * 支持memcached的几个要点
     * 1, 指定该包下支持spring aop注解
     * 2, 持久化对象需要序列化
     * 3, 使用 通知 @ReadThroughSingleCache
     *
         组件所提供的切入点主要包括以下几种：
         ReadThroughSingleCache、ReadThroughMultiCache、ReadThroughAssignCache
         当遇到查询方法声明这些切入点时，组件首先会从缓存中读取数据，取到数据则跳过查询方法，直接返回。
         取不到数据在执行查询方法，并将查询结果放入缓存，以便下一次获取。
         InvalidateSingleCache、InvalidateMultiCache、InvalidateAssignCache
         当遇到删除方法声明这些切入点时，组件会删除缓存中的对应实体
         UpdateSingleCache、UpdateMultiCache、UpdateAssignCache
         当遇到更新方法声明这些切入点是，组件会更新缓存中对应的实体，以便下次从缓存中读取出的数据状态是最新的
     */

    @Resource
    private UserMapper userMapper;

    public List<User> findAll() {
        return userMapper.findAll();
    }

    @ReadThroughSingleCache( namespace = Context.USER_INFO , expiration = 60)
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
