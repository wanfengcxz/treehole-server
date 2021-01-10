package com.treehole.entity;

import org.apache.ibatis.type.Alias;

/**
 * @author W.Q
 * @project treehole
 * @package com.treehole.entity
 * @date 2021.01.06
 */

@Alias("message")
public class Message {

    private int id;
    private int user_id;
    private String user_name;
    private String face_url;
    private String content;
    private int total_likes;
    private int send_timestamp;

    public Message() {
    }

    public Message(int id, int use_id, String user_name, String face_url, String content, int total_likes, int send_timestamp) {
        this.id = id;
        this.user_id = use_id;
        this.user_name = user_name;
        this.face_url = face_url;
        this.content = content;
        this.total_likes = total_likes;
        this.send_timestamp = send_timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getFace_url() {
        return face_url;
    }

    public void setFace_url(String face_url) {
        this.face_url = face_url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getTotal_likes() {
        return total_likes;
    }

    public void setTotal_likes(int total_likes) {
        this.total_likes = total_likes;
    }

    public int getSend_timestamp() {
        return send_timestamp;
    }

    public void setSend_timestamp(int send_timestamp) {
        this.send_timestamp = send_timestamp;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", face_url='" + face_url + '\'' +
                ", content='" + content + '\'' +
                ", total_likes=" + total_likes +
                ", send_timestamp=" + send_timestamp +
                '}';
    }
}
