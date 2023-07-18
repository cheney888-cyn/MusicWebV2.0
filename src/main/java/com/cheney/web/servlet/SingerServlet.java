package com.cheney.web.servlet;


import com.alibaba.fastjson.JSON;
import com.cheney.pojo.PageBean;
import com.cheney.pojo.Singer;
import com.cheney.pojo.Song;
import com.cheney.service.SingerService;
import com.cheney.service.SongService;
import com.cheney.service.impl.SingerServiceImpl;
import com.cheney.service.impl.SongServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/singer/*")
public class SingerServlet extends BaseServlet{
    private SingerService singerService = new SingerServiceImpl();
    public void selectAllsingers(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        //调用service查询
        List<Singer> singers = singerService.selectAllSinger();
        //转为json格式
        String jsonString= JSON.toJSONString(singers);
        //写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }
    public void selectSingerByHits(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        //调用service查询
        List<Singer> singers = singerService.selectSingerByHits();
        //转为json格式
        String jsonString= JSON.toJSONString(singers);
        //写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }
    public void selectSingerIntro(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        //调用service查询
        List<Singer> singers = singerService.selectSingerIntro();
        //转为json格式
        String jsonString= JSON.toJSONString(singers);
        //写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }


}
