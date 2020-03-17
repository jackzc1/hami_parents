package com.soft.service.impl;

import com.soft.dao.MtypeMapper;
import com.soft.model.Mtype;
import com.soft.service.MtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MtypeServiceImpl implements MtypeService {

    @Autowired
    private MtypeMapper mtypeMapper;

    @Override
    public int deleteByPrimaryKey(Integer tid) {
        return mtypeMapper.deleteByPrimaryKey(tid);
    }

    @Override
    public int insert(Mtype record) {
        return mtypeMapper.insert(record);
    }

    @Override
    public int insertSelective(Mtype record) {
        return mtypeMapper.insertSelective(record);
    }

    @Override
    public Mtype selectByPrimaryKey(Integer tid) {
        return mtypeMapper.selectByPrimaryKey(tid);
    }

    @Override
    public int updateByPrimaryKeySelective(Mtype record) {
        return mtypeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Mtype record) {
        return mtypeMapper.updateByPrimaryKey(record);
    }
}
