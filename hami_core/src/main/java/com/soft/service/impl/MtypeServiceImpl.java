package com.soft.service.impl;

import com.soft.dao.MtypeMapper;
import com.soft.model.Mtype;
import com.soft.service.MtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MtypeServiceImpl extends BaseServiceImpl<Mtype> implements MtypeService {

    private MtypeMapper mtypeMapper;

    @Autowired
    public void setMtypeMapper(MtypeMapper mtypeMapper) {
        this.mtypeMapper = mtypeMapper;
        this.baseMapper = mtypeMapper;
    }
}
