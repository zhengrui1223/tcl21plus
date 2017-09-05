package com.movit.service.impl.base;

import com.movit.model.base.BaseEntity;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

public abstract class BaseService {
    private static final Log log = LogFactory.getLog(BaseService.class);

    @Autowired
    private RedisTemplate<String, BaseEntity> redisTemplate;

    @Resource(name = "redisTemplate")
    private ValueOperations<String, BaseEntity> valueOperations;


    public void findAllEntityInCacheByPrefix(String pattern, List targetList) {
        try {
            Set<String> keys = redisTemplate.keys(pattern);

            if (keys != null && !keys.isEmpty()) {
                for (String key : keys) {
                    targetList.add(valueOperations.get(key));
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }

    }

    public void updateEntity2Cache(String prefix, BaseEntity target) {
        try {
            if (target != null && target.getId() != null) {
                String key = prefix + target.getId();
                redisTemplate.delete(key);
                valueOperations.set(key, target);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public void deleteEntityInCache(String key) {
        try {
            redisTemplate.delete(key);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public BaseEntity queryEntityFromCache(String key) {
        try {
            return valueOperations.get(key);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

}
