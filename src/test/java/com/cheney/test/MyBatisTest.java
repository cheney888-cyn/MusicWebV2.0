package com.cheney.test;

import com.cheney.mapper.SingerMapper;
import com.cheney.mapper.SongMapper;
import com.cheney.mapper.UserMapper;
import com.cheney.mapper.UserSongMapper;
import com.cheney.pojo.Artist;
import com.cheney.pojo.Singer;
import com.cheney.pojo.Song;
import com.cheney.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
public class MyBatisTest {

    @Test
    public void test() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取Mapper
        SongMapper songMapper = sqlSession.getMapper(SongMapper.class);
        List<Song> songs = songMapper.selectAllSong();
        System.out.println(songs);
        //关闭sqlSession
        sqlSession.close();
    }
    @Test
    public void testbyId() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取Mapper
        SongMapper songMapper = sqlSession.getMapper(SongMapper.class);
        Song song = songMapper.selectSongById(33);
        System.out.println(song);
        //关闭sqlSession
        sqlSession.close();
    }
    @Test
    public void selectSongByPageAndCondition() throws IOException {
        //接收参数
        String songName = "拜";
        String singer = "1";
        int status = 1;
        int start =0;
        int end =5;
        Song song = new Song();
        //处理参数
        songName = "%"+songName+"%";
        song.setSinger(singer);
        song.setSongName(songName);
        song.setStatus(status);
        System.out.println(song);
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取Mapper
        SongMapper songMapper = sqlSession.getMapper(SongMapper.class);
        List<Song> songs = songMapper.selectSongByPageCondition(start,end,status,singer,songName);
        System.out.println(songs);
        //关闭sqlSession
        sqlSession.close();
    }
    @Test
    public void addUser() throws IOException {
        //接收参数
        String manager = "cheney";
        String pwd = "password";

        //处理参数
        //manager = "%"+manager+"%";
        //pwd = "%"+pwd+"%";
        //封装对象
        User user = new User();
        user.setManager(manager);
        user.setPwd(pwd);
        //获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取Mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.insertUser(user);
        int id= user.getId();
        System.out.println(id);

        //关闭sqlSession
        sqlSession.close();
    }
    @Test
    public void updatePwd() throws IOException {
        //接收参数
        int id = 100;
        String newPwd = "password";

        //处理参数

        //封装对象
        User user = new User();
        user.setId(id);
        user.setPwd(newPwd);
        //获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取Mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int count= userMapper.updatePwd(user);
        System.out.println(count);

        //关闭sqlSession
        sqlSession.close();
    }
    @Test
    public void deleteSongbyId() throws IOException {
        //接收参数
        int id = 33;
        //获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取Mapper
        SongMapper songMapper = sqlSession.getMapper(SongMapper.class);
        songMapper.deleteSongById(id);
        //System.out.println(count);

        //关闭sqlSession
        sqlSession.close();
    }
    @Test
    public void deleteSongbyIds() throws IOException {
        //接收参数
        int[] ids = {1,2};
        //获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取Mapper
        SongMapper songMapper = sqlSession.getMapper(SongMapper.class);
        //调用方法
        songMapper.deleteSongByIds(ids);
        //System.out.println(count);
        //关闭sqlSession
        sqlSession.close();
    }
    @Test
    public void addsong() throws IOException {
        //接收参数
         String sN="name";
         String singer="me";
         String url = "3.mp3";
         int hits = 5;
         String  type = "6";
         int st=0;

        //封装对象
        Song song = new Song();
        song.setSongName(sN);
        //song.setSinger(singer);
        song.setFileURL(url);
        song.setType(type);
        song.setStatus(st);
        //song.setHits(hits);
        //获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
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
    @Test
    public void selectSingerbyHits() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取Mapper
        SingerMapper singerMapper = sqlSession.getMapper(SingerMapper.class);
        List<Singer> artists = singerMapper.selectSingerByHits();
        System.out.println(artists);
        //关闭sqlSession4
        sqlSession.close();
    }
    @Test
    public void selectAllSinger() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取Mapper
        SingerMapper singerMapper = sqlSession.getMapper(SingerMapper.class);
        List<Singer> artists = singerMapper.selectAllSinger();
        System.out.println(artists);
        //关闭sqlSession
        sqlSession.close();
    }
    @Test
    public void selectAlluserSong() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取Mapper
        UserSongMapper userSongMapper = sqlSession.getMapper(UserSongMapper.class);
        List<Song> artists = userSongMapper.selectAllSongByUserId(2);
        System.out.println(artists);
        //关闭sqlSession
        sqlSession.close();
    }
    @Test
    public void userLogin() throws IOException {
        //接收参数
        String name = "test09";
        String pwd = "123";
        User user = new User();
        //处理参数
        user.setManager(name);
        user.setPwd(pwd);
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取Mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //String flag = userMapper.login(user);
       // System.out.println(flag);
        //关闭sqlSession
        sqlSession.close();
    }
    @Test
    public void userCheck() throws IOException {
        //接收参数
        String name = "test10                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   ";
        String pwd = "123";
        User user = new User();
        //处理参数
        user.setManager(name);
        user.setPwd(pwd);
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取Mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int flag = userMapper.checkUser(user);
        System.out.println(flag);
        //关闭sqlSession
        sqlSession.close();
    }
}
