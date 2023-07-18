package com.cheney.service;

import com.cheney.pojo.PageBean;
import com.cheney.pojo.Song;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SongService {

    List<Song> selectAllSong();
    void addSong(Song song);
    //歌曲批量删除
    public  void deleteSongByIds( int[] ids);
    PageBean<Song> selectSongByPage(int currentPage, int rows);
    PageBean<Song> selectSongByPageAndCondition(int currentPage, int rows, int status, String singer, String songName);
    void deleteSongById(int id);
    void updateSongStatus(int id,int status);
    List<Song> selectSongByHitsFive();
    List<String> selectSongByType();
    List<Song> selectSongByCollection(int userID);
    void updateSongHits(int id);
}
