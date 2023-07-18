package com.cheney.web.servlet;
import com.alibaba.fastjson.JSON;
import com.cheney.pojo.PageBean;
import com.cheney.pojo.Song;
import com.cheney.pojo.User;
import com.cheney.service.UserService;
import com.cheney.service.UserSongService;
import com.cheney.service.impl.UserServiceImpl;
import com.cheney.service.impl.UserSongServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/usersong/*")
public class UserSongServlet extends BaseServlet{
    private UserSongService userSongService = new UserSongServiceImpl();

    public void insertUserSong(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        //接受参数
        String _userID = req.getParameter("user");
        String _songID = req.getParameter("song");
        int userID= Integer.parseInt(_userID);
        int songID= Integer.parseInt(_songID);
        //调用service查询
        userSongService.addSongtoUser(userID,songID);
        //转为json格式
        resp.setContentType("text/json;charset=utf-8");
        //响应成功标识
        resp.getWriter().write("susscess");
    }

}
