package com.soft.service.impl;

import com.soft.dao.AlbumMapper;
import com.soft.model.Album;
import com.soft.query.AlbumQuery;
import com.soft.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumServiceImpl extends BaseServiceImpl<AlbumQuery, Album> implements AlbumService {

    private AlbumMapper albumMapper;

    @Autowired
    public void setMtypeMapper(AlbumMapper albumMapper) {
        this.albumMapper = albumMapper;
        this.baseMapper = albumMapper;
    }
}
