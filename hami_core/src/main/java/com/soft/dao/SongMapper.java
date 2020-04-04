package com.soft.dao;

import com.soft.model.Song;
import com.soft.query.SongQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SongMapper extends BaseMapper<SongQuery, Song> {

    int updateByPrimaryKeyLRC(Song record);

    List<Song> selectByListsIds(@Param("sids") List<Integer> sids);

    Song selectBysid1(Integer sid);
}