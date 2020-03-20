package com.soft.service.impl;

import com.soft.dao.BaseMapper;
import com.soft.service.BaseService;
import com.soft.util.Page;

import java.lang.reflect.Method;
import java.util.List;

public class BaseServiceImpl<Q,T> implements BaseService<Q, T> {

    protected BaseMapper<Q, T> baseMapper;

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

    @Override
    public List<T> selectByCondition(Q q) {
        return baseMapper.selectByCondition(q);
    }

    @Override
    public Integer selectByConditionConut(Q q) {
        return baseMapper.selectByConditionConut(q);
    }

    @Override
    public Page<T> selectByConditionPage(Q q) {
        Page<T> page = new Page<>();
        Class<?> qClass = q.getClass();
        try {
            //获取pageSize和pageNo来设置startNum
            Method getPageNo = qClass.getDeclaredMethod("getPageNo", null);
            Method getPageSize = qClass.getDeclaredMethod("getPageSize", null);
            Integer pageNo = (Integer) getPageNo.invoke(q, null);
            Integer pageSize = (Integer) getPageSize.invoke(q, null);
            Method setStartNum = qClass.getDeclaredMethod("setStartNum", new Class[]{Integer.class});
            setStartNum.invoke(qClass, (pageNo - 1) * pageSize);
            //设置分页对象属性
            page.setStartNum((pageNo - 1) * pageSize);
            page.setList(baseMapper.selectByCondition(q));
            page.setTotalCount(baseMapper.selectByConditionConut(q));
            page.setPageNo(pageNo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return page;
    }
}
