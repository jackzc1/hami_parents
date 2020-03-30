package com.soft.service.impl;

import com.soft.dao.SongMapper;
import com.soft.model.Song;
import com.soft.query.SongQuery;
import com.soft.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongServiceImpl extends BaseServiceImpl<SongQuery, Song> implements SongService {

    private SongMapper songMapper;

    @Autowired
    public void setSongerMapper(SongMapper songMapper) {
        this.songMapper = songMapper;
        this.baseMapper = songMapper;
    }

    @Override
    public int updateByPrimaryKeyLRC(Song record) {
        return songMapper.updateByPrimaryKeyLRC(record);
    }
}
