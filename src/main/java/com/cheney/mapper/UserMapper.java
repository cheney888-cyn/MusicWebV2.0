package com.cheney.mapper;

import com.cheney.pojo.User;

import java.util.List;

public interface UserMapper {

    public List<User> selectAllUser();
    public void insertUser(User user);
    public int updatePwd(User user);
    //登录验证
    public String login(User user);
    //用户校验
    public int checkUser(User user);
}
