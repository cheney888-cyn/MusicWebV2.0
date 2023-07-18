package com.cheney.mapper;


import com.cheney.pojo.Song;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserSongMapper {
    //  查询所有收藏歌曲
    List<Song> selectAllSongByUserId(int userID);
    //  添加收藏歌曲
    void addSongToUser(@Param("userID") int userID, @Param("songID") int songID);

}
