package com.cheney.service.impl;
import com.cheney.mapper.SingerMapper;
import com.cheney.mapper.SongMapper;
import com.cheney.mapper.UserMapper;
import com.cheney.pojo.PageBean;
import com.cheney.pojo.Singer;
import com.cheney.pojo.Song;
import com.cheney.pojo.User;
import com.cheney.service.SingerService;
import com.cheney.service.UserService;
import com.cheney.util.SqlSessionFactoryUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;


public class UserServiceImpl implements UserService {
    //创建对应的sqlSessionFactroy对象
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryUtils().getSqlSessionFactory();


    @Override
    public List<Singer> selectAllUser() {
        return null;
    }

    @Override
    public void insertUser(User user) {
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取对应的SongMapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用方法
        userMapper.insertUser(user);
        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }

    @Override
    public int updatePwd(User user) {
        return 0;
    }

    @Override
    public String login(User user) {
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取对应的SongMapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        String flag = userMapper.login(user);
        //提交事务
        System.out.println(flag);
        //释放资源
        sqlSession.close();
        return flag;
    }

    @Override
    public int checkUser(User user) {
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取对应的SongMapper
        //获取Mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int flag = userMapper.checkUser(user);
        System.out.println("flag="+flag);
        //关闭sqlSession
        sqlSession.close();
        return flag;
    }
}
