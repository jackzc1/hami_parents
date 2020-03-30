package com.soft.service;

import com.soft.model.Song;
import com.soft.model.Songer;
import com.soft.query.SongQuery;
import com.soft.query.SongerQuery;

public interface SongService extends BaseService<SongQuery, Song> {

    int updateByPrimaryKeyLRC(Song record);

}
