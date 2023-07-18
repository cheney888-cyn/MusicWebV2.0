package com.cheney.web.servlet;


import com.alibaba.fastjson.JSON;
import com.cheney.pojo.PageBean;
import com.cheney.pojo.Song;
import com.cheney.service.SongService;
import com.cheney.service.impl.SongServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/song/*")
public class SongServlet extends BaseServlet{
    private SongService songService = new SongServiceImpl();
    public void selectAll(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        //调用service查询
        List<Song> songs = songService.selectAllSong();
        //转为json格式
        String jsonString= JSON.toJSONString(songs);
        //写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }
    public void add(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        //接受数据
        BufferedReader br = req.getReader();
        String params = br.readLine();

        //JSON转换为Song对象
        Song song = JSON.parseObject(params,Song.class);
        //调用service添加
        songService.addSong(song);
        //响应成功标识
        resp.getWriter().write("success");
    }
    public void deleteByids(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        //接受数据 [1,2,3]
        BufferedReader br = req.getReader();
        String params = br.readLine();
        //JSON转换为Song对象
        int[] ids = JSON.parseObject(params,int[].class);
        //调用service添加
        songService.deleteSongByIds(ids);
        //响应成功标识
        resp.getWriter().write("delete by ids success");
    }
    public void selectByPage(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        //接受参数  url?currentPage=1&rows=5
        String _currentPage = req.getParameter("currentPage");
        String _rows = req.getParameter("rows");
        int currentPage= Integer.parseInt(_currentPage);
        int rows= Integer.parseInt(_rows);
        //调用service查询
        PageBean<Song> pageBean = songService.selectSongByPage(currentPage,rows);
        //转为json格式
        String jsonString= JSON.toJSONString(pageBean);
        //写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }
    public void selectByPageAndCondition(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        //接受参数  url?currentPage=1&rows=5&status=1&singer=1&songName=崇拜
        String _currentPage = req.getParameter("currentPage");
        String _rows = req.getParameter("rows");
        String _status = req.getParameter("status");
        String singer = req.getParameter("singer");
        String songName = req.getParameter("songName");
        int currentPage= Integer.parseInt(_currentPage);
        int rows= Integer.parseInt(_rows);
        int status= Integer.parseInt(_status);
        //调用service查询
        PageBean<Song> pageBean = songService.selectSongByPageAndCondition(currentPage,rows,status,singer,songName);
        //转为json格式
        String jsonString= JSON.toJSONString(pageBean);
        //写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }
    public void updateSongStatus(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        //接受数据
        BufferedReader br = req.getReader();
        String params = br.readLine();
        //JSON转换为Song对象
        Song song = JSON.parseObject(params,Song.class);
        //调用service添加
        songService.updateSongStatus(song.getId(),song.getStatus());
        //响应成功标识
        resp.getWriter().write("success");
    }
    public void selectSongByHitsFive(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        //调用service查询
        List<Song> songs = songService.selectSongByHitsFive();
        //转为json格式
        String jsonString= JSON.toJSONString(songs);
        //写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }
    public void selectSongByType(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        //调用service查询
        List<String> types = songService.selectSongByType();
        //转为json格式
        String jsonString= JSON.toJSONString(types);
        //写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }
    public void selectSongByCollection(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        String _userID = req.getParameter("user");
        int userID= Integer.parseInt(_userID);
        //调用service查询
        List<Song> songs = songService.selectSongByCollection(userID);
        //转为json格式
        String jsonString= JSON.toJSONString(songs);
        //写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }
    public void updateSongHits(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        //接受数据
        BufferedReader br = req.getReader();
        String params = br.readLine();
        //JSON转换为Song对象
        int song = JSON.parseObject(params,Integer.class);
        //调用service添加
        songService.updateSongHits(song);
        //响应成功标识
        resp.getWriter().write("success");
    }


}
