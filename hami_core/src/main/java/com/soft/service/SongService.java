package com.soft.service;

import com.soft.model.Song;
import com.soft.model.Songer;
import com.soft.query.SongQuery;
import com.soft.query.SongerQuery;

import java.util.List;

public interface SongService extends BaseService<SongQuery, Song> {

    int updateByPrimaryKeyLRC(Song record);

    List<Song> selectByListsIds(List<Integer> sids);

    Song selectBysid1(Integer sid);

}
