package com.cheney.service.impl;
import com.cheney.mapper.SongMapper;
import com.cheney.mapper.UserMapper;
import com.cheney.mapper.UserSongMapper;
import com.cheney.pojo.Singer;
import com.cheney.pojo.User;
import com.cheney.service.UserService;
import com.cheney.service.UserSongService;
import com.cheney.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;


public class UserSongServiceImpl implements UserSongService {
    //创建对应的sqlSessionFactroy对象
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryUtils().getSqlSessionFactory();


    @Override
    public void addSongtoUser(int userID, int songID) {
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取对应的SongMapper
        UserSongMapper usersongMapper = sqlSession.getMapper(UserSongMapper.class);
        //调用方法
        usersongMapper.addSongToUser(userID,songID);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }
}
