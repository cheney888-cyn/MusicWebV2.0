package com.cheney.service;

import com.cheney.pojo.Singer;
import com.cheney.pojo.User;

import java.util.List;

public interface UserSongService {

   void addSongtoUser(int userID,int songID);

}
