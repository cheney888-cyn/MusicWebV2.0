package com.cheney.service;

import com.cheney.pojo.PageBean;
import com.cheney.pojo.Singer;
import com.cheney.pojo.Song;

import java.util.List;

public interface SingerService {

    List<Singer> selectAllSinger();
    List<Singer> selectSingerByHits();
    List<Singer> selectSingerIntro();

}
