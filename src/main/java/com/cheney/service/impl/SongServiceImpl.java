package com.cheney.service.impl;
import com.cheney.mapper.SongMapper;
import com.cheney.pojo.PageBean;
import com.cheney.pojo.Song;
import com.cheney.pojo.User;
import com.cheney.service.SongService;
import com.cheney.util.SqlSessionFactoryUtils;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;



public class SongServiceImpl implements SongService {
    //创建对应的sqlSessionFactroy对象
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryUtils().getSqlSessionFactory();

    @Override
    public List<Song> selectAllSong() {
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取对应的SongMapper
        SongMapper songMapper = sqlSession.getMapper(SongMapper.class);
        //调用方法
        List<Song> songs = songMapper.selectAllSong();
        System.out.println(songs);
        //关闭sqlSession
        sqlSession.close();
        return songs;
    }

    @Override
    public void addSong(Song song) {
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取对应的SongMapper
        SongMapper songMapper = sqlSession.getMapper(SongMapper.class);
        //调用方法
        songMapper.addSong(song);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }
    @Override
    //歌曲批量删除
    public void deleteSongByIds( int[] ids){
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取对应的SongMapper
        SongMapper songMapper = sqlSession.getMapper(SongMapper.class);
        //调用方法
        songMapper.deleteSongByIds(ids);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    @Override
    public PageBean<Song> selectSongByPage(int currentPage, int rows) {
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取对应的SongMapper
        SongMapper songMapper = sqlSession.getMapper(SongMapper.class);
        //计算查询条目数
        int begin=(currentPage-1)*rows;
        int size =rows;
        List<Song> songs = songMapper.selectSongByPage(begin,size);
        int totalCount = songMapper.selectTotalCount();
        //封装PageBean
        PageBean<Song> pb = new PageBean<>();
        pb.setRows(songs);
        pb.setTotalCount(totalCount);
        //释放资源
        sqlSession.close();
        return pb;
    }

    @Override
    public PageBean<Song> selectSongByPageAndCondition(int currentPage, int rows, int status, String singer, String songName) {
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取对应的SongMapper
        SongMapper songMapper = sqlSession.getMapper(SongMapper.class);
        //计算查询条目数
        int begin=(currentPage-1)*rows;
        int size =rows;
        //处理song条件，设置模糊表达式
        songName = "%" + songName + "%";
        List<Song> songs = songMapper.selectSongByPageCondition(begin,size,status,singer,songName);
        int totalCount = songMapper.selectTotalCountByCondition(status,singer,songName);
        //封装PageBean
        PageBean<Song> pb = new PageBean<>();
        pb.setRows(songs);
        pb.setTotalCount(totalCount);
        //释放资源
        sqlSession.close();
        return pb;
    }

    @Override
    public void deleteSongById(int id) {
        //接收参数
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取对应的SongMapper
        SongMapper songMapper = sqlSession.getMapper(SongMapper.class);
        songMapper.deleteSongById(id);
        //System.out.println(count);

        //关闭sqlSession
        sqlSession.close();
    }

    @Override
    public void updateSongStatus(int id, int status) {
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取对应的SongMapper
        SongMapper songMapper = sqlSession.getMapper(SongMapper.class);
        songMapper.updateSongStatus(id,status);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    @Override
    public List<Song> selectSongByHitsFive() {
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取对应的SongMapper
        SongMapper songMapper = sqlSession.getMapper(SongMapper.class);
        //调用方法
        List<Song> songs = songMapper.selectSongByHitsFive();
        System.out.println(songs);
        //关闭sqlSession
        sqlSession.close();
        return songs;
    }

    @Override
    public List<String> selectSongByType() {
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取对应的SongMapper
        SongMapper songMapper = sqlSession.getMapper(SongMapper.class);
        //调用方法
        List<String> songs = songMapper.selectSongByType();
        System.out.println(songs);
        //关闭sqlSession
        sqlSession.close();
        return songs;
    }

    @Override
    public List<Song> selectSongByCollection(int userID) {//获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取对应的SongMapper
        SongMapper songMapper = sqlSession.getMapper(SongMapper.class);
        //调用方法
        List<Song> songs = songMapper.selectSongByCollection(userID);
        System.out.println(songs);
        //关闭sqlSession
        sqlSession.close();
        return songs;
    }

    @Override
    public void updateSongHits(int id) {
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取对应的SongMapper
        SongMapper songMapper = sqlSession.getMapper(SongMapper.class);
        songMapper.updateSongHits(id);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }
}
