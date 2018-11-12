package com.baizhi.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseDao<T> {
    void insert(T t);
    void update(T t);
    void delete(String id);
    List<T> query();
    T queryOne(String id);
    void deleteMany(String[] id);

    T login(T t);
    T querySalt(T t);

    List<T> findByPage(@Param("start") Integer start, @Param("rows") Integer rows);
    Long findTotals();


}
