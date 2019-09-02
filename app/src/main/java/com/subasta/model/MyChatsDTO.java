package com.subasta.model;

import java.io.Serializable;

public class MyChatsDTO implements Serializable {
    private String chat_id;
    private String date;

    /* renamed from: id */
    private String f1316id;
    private String message;
    private String receiver_user_pub_id;
    private String sender_user_pub_id;
    private String thread_id;
    private String user_image;
    private String user_name;

    public MyChatsDTO() {
        String str = "";
        this.chat_id = str;
        this.sender_user_pub_id = str;
        this.receiver_user_pub_id = str;
        this.message = str;
        this.date = str;
        this.user_name = str;
        this.user_image = str;
        this.thread_id = str;
        this.f1316id = str;
    }

    public String getChat_id() {
        return this.chat_id;
    }

    public void setChat_id(String str) {
        this.chat_id = str;
    }

    public String getSender_user_pub_id() {
        return this.sender_user_pub_id;
    }

    public void setSender_user_pub_id(String str) {
        this.sender_user_pub_id = str;
    }

    public String getReceiver_user_pub_id() {
        return this.receiver_user_pub_id;
    }

    public void setReceiver_user_pub_id(String str) {
        this.receiver_user_pub_id = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public String getUser_name() {
        return this.user_name;
    }

    public void setUser_name(String str) {
        this.user_name = str;
    }

    public String getUser_image() {
        return this.user_image;
    }

    public void setUser_image(String str) {
        this.user_image = str;
    }

    public String getThread_id() {
        return this.thread_id;
    }

    public void setThread_id(String str) {
        this.thread_id = str;
    }

    public String getId() {
        return this.f1316id;
    }

    public void setId(String str) {
        this.f1316id = str;
    }
}
