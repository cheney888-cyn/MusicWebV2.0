package com.cheney.web.servlet.old;

import com.alibaba.fastjson.JSON;
import com.cheney.pojo.Song;
import com.cheney.service.SongService;
import com.cheney.service.impl.SongServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

//@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {

    private SongService songService = new SongServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用service查询
        List<Song> songs = songService.selectAllSong();
        //转为json格式
        String jsonString= JSON.toJSONString(songs);
        //写数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
