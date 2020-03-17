package com.soft.service;

import java.util.List;

public interface BaseService<T> {
    int deleteByPrimaryKey(Integer tid);

    int insert(T record);

    T selectByPrimaryKey(Integer tid);

    int updateByPrimaryKey(T record);

    List<T> selectAll();
}
