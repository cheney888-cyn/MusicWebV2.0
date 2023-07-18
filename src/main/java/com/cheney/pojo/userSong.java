package com.cheney.pojo;

public class userSong {
   private Integer id;
   private Integer userId;
   private Integer songId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    @Override
    public String toString() {
        return "userSong{" +
                "id=" + id +
                ", userId=" + userId +
                ", songId=" + songId +
                '}';
    }
}
