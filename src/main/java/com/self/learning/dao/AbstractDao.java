package com.self.learning.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public abstract class AbstractDao<T> implements BaseDao<T>{

    @Autowired
    protected RedisTemplate<String,T> redisTemplate;
}
