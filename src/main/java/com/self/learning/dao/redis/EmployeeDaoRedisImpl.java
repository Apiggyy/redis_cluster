package com.self.learning.dao.redis;

import com.self.learning.dao.AbstractDao;
import com.self.learning.entity.customer.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class EmployeeDaoRedisImpl extends AbstractDao<Employee> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean insert(String key, Employee employee) {
        return insert(key, employee, -1);
    }

    @Override
    public boolean insert(String key, Employee employee, long time) {
        try {
            ValueOperations<String, Employee> valueOps =  redisTemplate.opsForValue();
            valueOps.set(key, employee);
            if (time > 0) redisTemplate.expire(key, time, TimeUnit.SECONDS);
            return true;
        } catch (Throwable t) {
            logger.error("缓存[" + key + "]失败, value[" + employee + "]", t);
        }
        return false;
    }

    @Override
    public boolean containsKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Throwable t) {
            logger.error("判断缓存存在失败key[" + key + ", error[" + t + "]");
        }
        return false;
    }

    @Override
    public boolean remove(String key) {
        try {
            redisTemplate.delete(key);
            return true;
        } catch (Throwable t) {
            logger.error("获取缓存失败key[" + key + ", error[" + t + "]");
        }
        return false;
    }

    @Override
    public Employee get(String key) {
        try {
            ValueOperations<String, Employee> valueOps =  redisTemplate.opsForValue();
            return valueOps.get(key);
        } catch (Throwable t) {
            logger.error("获取缓存失败key[" + key + ", error[" + t + "]");
        }
        return null;
    }
}
