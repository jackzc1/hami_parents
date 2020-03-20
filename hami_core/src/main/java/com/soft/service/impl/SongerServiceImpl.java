package com.soft.service.impl;

import com.soft.dao.SongerMapper;
import com.soft.model.Songer;
import com.soft.query.SongerQuery;
import com.soft.service.SongerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongerServiceImpl extends BaseServiceImpl<SongerQuery, Songer> implements SongerService {

    private SongerMapper songerMapper;

    @Autowired
    public void setSongerMapper(SongerMapper songerMapper) {
        this.songerMapper = songerMapper;
        this.baseMapper = songerMapper;
    }
}
