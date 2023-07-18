package com.cheney.service;

import com.cheney.pojo.Singer;
import com.cheney.pojo.User;

import java.util.List;

public interface UserService {

    List<Singer> selectAllUser();
    void insertUser(User user);
    int updatePwd(User user);
    //登录验证
    String login(User user);
    int checkUser(User user);

}
