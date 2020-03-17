package com.soft.service.impl;

import com.soft.dao.BaseMapper;
import com.soft.service.BaseService;

import java.util.List;

public class BaseServiceImpl<T> implements BaseService<T> {

    protected BaseMapper<T> baseMapper;

    @Override
    public int deleteByPrimaryKey(Integer tid) {
        return baseMapper.deleteByPrimaryKey(tid);
    }

    @Override
    public int insert(T record) {
        return baseMapper.insert(record);
    }

    @Override
    public T selectByPrimaryKey(Integer tid) {
        return baseMapper.selectByPrimaryKey(tid);
    }

    @Override
    public int updateByPrimaryKey(T record) {
        return baseMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<T> selectAll() {
        return baseMapper.selectAll();
    }
}
