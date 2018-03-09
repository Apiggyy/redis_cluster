package com.self.learning.dao;

public interface BaseDao<T> {

    boolean insert(String key,T t);

    boolean insert(String key,T t,long time);

    boolean containsKey(String key);

    boolean remove(String key);

    T get(String key);
}
