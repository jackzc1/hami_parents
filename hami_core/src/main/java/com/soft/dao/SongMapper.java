package com.soft.dao;

import com.soft.model.Song;

public interface SongMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(Song record);

    int insertSelective(Song record);

    Song selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(Song record);

    int updateByPrimaryKeyWithBLOBs(Song record);

    int updateByPrimaryKey(Song record);
}