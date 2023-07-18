package com.cheney.web.servlet;
import com.alibaba.fastjson.JSON;
import com.cheney.pojo.User;
import com.cheney.service.UserService;
import com.cheney.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet{
    private UserService userService = new UserServiceImpl();
    public void login(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        //接受数据
        BufferedReader br = req.getReader();
        String params = br.readLine();
        //JSON转换为Song对象
        User user = JSON.parseObject(params,User.class);
        //调用service添加
        String flag = userService.login(user);

        resp.getWriter().write(String.valueOf(flag));

    }
    public void insertUser(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        //接受数据
        BufferedReader br = req.getReader();
        String params = br.readLine();
        //JSON转换为Song对象
        User user = JSON.parseObject(params,User.class);
        System.out.println(user);
        //调用service添加
        userService.insertUser(user);
        //响应成功标识
        resp.getWriter().write("susscess");
    }
    public void checkUser(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        //接受数据
        BufferedReader br = req.getReader();
        String params = br.readLine();
        //JSON转换为Song对象
        User user = JSON.parseObject(params,User.class);
        //调用service添加
        int count = userService.checkUser(user);
        System.out.println(count);
        //响应成功标识
        resp.getWriter().write(String.valueOf(count));
    }

}
