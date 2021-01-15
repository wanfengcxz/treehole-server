package com.treehole.entity;

import org.apache.ibatis.type.Alias;

/**
 * @author W.Q
 * @project treehole
 * @package com.treehole.entity
 * @date 2021.01.06
 * @description model层 实体类
 */

@Alias("user")
public class User {

    private int id;
    private String user_name;
    private String phone;
    private String password;
    private String face_url;

    public User(){

    }

    public User(int id, String user_name, String phone, String password, String face_url) {
        this.id = id;
        this.user_name = user_name;
        this.phone = phone;
        this.password = password;
        this.face_url = face_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFace_url() {
        return face_url;
    }

    public void setFace_url(String face_url) {
        this.face_url = face_url;
    }
}
