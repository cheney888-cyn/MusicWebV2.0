package com.cheney.web.servlet.old;

import com.alibaba.fastjson.JSON;
import com.cheney.pojo.Song;
import com.cheney.service.SongService;
import com.cheney.service.impl.SongServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

//@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {

    private SongService songService = new SongServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受数据
        BufferedReader br = request.getReader();
        String params = br.readLine();

        //JSON转换为Song对象
        Song song = JSON.parseObject(params,Song.class);
        //调用service添加
        songService.addSong(song);
        //响应成功标识
        response.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
