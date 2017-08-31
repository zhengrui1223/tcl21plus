package com.movit.service.impl.base;

import com.movit.model.base.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

public abstract class BaseService {
    @Autowired
    private RedisTemplate<String, BaseEntity> redisTemplate;

    public void insertEntity2Cache(String prefix, BaseEntity target) {
        if (target != null && target.getId() != null) {
            String key = prefix + target.getId();
            ValueOperations<String, BaseEntity> operations = redisTemplate.opsForValue();
            redisTemplate.delete(key);
            operations.set(key, target);
        }
    }

    public void deleteEntityInCache(String key) {
        redisTemplate.delete(key);
    }

    public BaseEntity queryEntityFromCache(String key) {
        ValueOperations<String, BaseEntity> operations = redisTemplate.opsForValue();
        return operations.get(key);
    }

}
