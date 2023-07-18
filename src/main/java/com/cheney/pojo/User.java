package com.cheney.pojo;

public class User {
    private Integer id;
    private String manager;
    private String pwd;
    private String userFlag;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUserFlag() {
        return userFlag;
    }

    public void setUserFlag(String userFlag) {
        this.userFlag = userFlag;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", manager='" + manager + '\'' +
                ", pwd='" + pwd + '\'' +
                ", userFlag='" + userFlag + '\'' +
                '}';
    }
}
