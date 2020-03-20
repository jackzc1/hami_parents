package com.soft.service;

import com.soft.util.Page;

import java.util.List;

public interface BaseService<Q, T> {
    int deleteByPrimaryKey(Integer tid);

    int insert(T record);

    T selectByPrimaryKey(Integer tid);

    int updateByPrimaryKey(T record);

    List<T> selectAll();

    List<T> selectByCondition(Q q);

    Integer selectByConditionConut(Q q);

    Page<T> selectByConditionPage(Q q);
}
