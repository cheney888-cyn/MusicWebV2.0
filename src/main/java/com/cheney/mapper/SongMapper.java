package com.cheney.mapper;


import com.cheney.pojo.Song;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SongMapper {
    //歌曲全部查询
    @Select("select a.id,a.songName,b.singerName as singer,a.fileURL,a.hits,a.type,a.status from tb_song a,tb_singer b where a.singer=b.id order by a.id")
    public  List<Song> selectAllSong();
    //歌曲编号查询
    public Song selectSongById(int song_id);
    //歌曲条件筛选
    public  List<Song> selectSongByCondition(@Param("songName") String songName, @Param("singer") String singer, @Param("status") int status);
    //歌曲单独删除
    public  void deleteSongById(int id);
    //歌曲批量删除
    public  void deleteSongByIds(@Param("ids") int[] ids);
    //歌曲添加
    public void addSong(Song song);
    //歌曲按热度排序
    public List<Song> selectSongByHits();
    //分页查询
    @Select("select a.id,a.songName,b.singerName as singer,a.fileURL,a.hits,a.type,a.status from tb_song a,tb_singer b where a.singer=b.id order by a.id limit #{start},#{rows}")
    List<Song> selectSongByPage(@Param("start") int start, @Param("rows") int rows);
    //查询总条数
    @Select("select count(*) from tb_song")
    int selectTotalCount();
    //分页条件查询
    List<Song> selectSongByPageCondition(@Param("start") int start, @Param("rows") int rows,@Param("status") int status,@Param("singer")String singer,@Param("songName")String songName);
    //查询条件下总条数
    int selectTotalCountByCondition(@Param("status") int status, @Param("singer") String singer, @Param("songName") String songName);
    //更新歌曲状态
    void updateSongStatus(@Param("id") int id,@Param("status") int status);
    //歌曲热门前五
    List<Song> selectSongByHitsFive();
    //选择所有歌曲类型
    List<String> selectSongByType();
    //收藏歌曲查询
    List<Song> selectSongByCollection(@Param("userID") int userID);
    //歌曲热度更新
    void updateSongHits(@Param("id") int id);
}
