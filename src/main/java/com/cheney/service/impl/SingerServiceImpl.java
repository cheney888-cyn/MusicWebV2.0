package com.cheney.service.impl;
import com.cheney.mapper.SingerMapper;
import com.cheney.mapper.SongMapper;
import com.cheney.pojo.PageBean;
import com.cheney.pojo.Singer;
import com.cheney.pojo.Song;
import com.cheney.service.SingerService;
import com.cheney.service.SongService;
import com.cheney.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;


public class SingerServiceImpl implements SingerService {
    //创建对应的sqlSessionFactroy对象
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryUtils().getSqlSessionFactory();

    @Override
    public List<Singer> selectAllSinger() {
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取对应的SongMapper
        SingerMapper singerMapper = sqlSession.getMapper(SingerMapper.class);
        //调用方法
        List<Singer> singers = singerMapper.selectAllSinger();
        System.out.println(singers);
        //关闭sqlSession
        sqlSession.close();
        return singers;
    }

    @Override
    public List<Singer> selectSingerByHits() {
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取对应的SongMapper
        SingerMapper singerMapper = sqlSession.getMapper(SingerMapper.class);
        //调用方法
        List<Singer> singers = singerMapper.selectSingerByHits();
        System.out.println(singers);
        //关闭sqlSession
        sqlSession.close();
        return singers;
    }

    @Override
    public List<Singer> selectSingerIntro() {
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取对应的SongMapper
        SingerMapper singerMapper = sqlSession.getMapper(SingerMapper.class);
        //调用方法
        List<Singer> singers = singerMapper.selectSingerIntro();
        System.out.println(singers);
        //关闭sqlSession
        sqlSession.close();
        return singers;
    }
}
