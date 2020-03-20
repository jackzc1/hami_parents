package com.soft.dao;

import com.soft.model.Mtype;

import java.util.List;

public interface BaseMapper<Q, T> {

    int deleteByPrimaryKey(Integer tid);

    int insert(T record);

    T selectByPrimaryKey(Integer tid);

    int updateByPrimaryKey(T record);

    List<T> selectAll();

    List<T> selectByCondition(Q q);

    Integer selectByConditionConut(Q q);
}
