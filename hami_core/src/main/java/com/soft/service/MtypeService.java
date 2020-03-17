package com.soft.service;

import com.soft.model.Mtype;

public interface MtypeService {
    int deleteByPrimaryKey(Integer tid);

    int insert(Mtype record);

    int insertSelective(Mtype record);

    Mtype selectByPrimaryKey(Integer tid);

    int updateByPrimaryKeySelective(Mtype record);

    int updateByPrimaryKey(Mtype record);
}
