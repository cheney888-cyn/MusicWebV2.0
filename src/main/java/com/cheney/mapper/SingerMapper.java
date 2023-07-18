package com.cheney.mapper;
import com.cheney.pojo.Artist;
import com.cheney.pojo.Singer;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SingerMapper {
    //歌手名单查询
    @Select("select id,singerName from tb_singer")
    public  List<Singer> selectAllSinger();
    //歌手信息查询
    @Select("select * from tb_singer")
    public List<Singer> selectSingerIntro();
    //歌曲按热度排序
    public List<Singer> selectSingerByHits();

}
