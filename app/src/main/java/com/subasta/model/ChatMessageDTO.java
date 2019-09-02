package com.subasta.model;

import java.io.Serializable;

public class ChatMessageDTO implements Serializable {
    private String chat_id;
    private String date;
    private String message;
    private String receiver_name;
    private String receiver_user_pub_id;
    private String sender_name;
    private String sender_user_pub_id;

    public ChatMessageDTO() {
        String str = "";
        this.chat_id = str;
        this.sender_user_pub_id = str;
        this.receiver_user_pub_id = str;
        this.message = str;
        this.sender_name = str;
        this.date = str;
        this.receiver_name = str;
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

    public String getSender_name() {
        return this.sender_name;
    }

    public void setSender_name(String str) {
        this.sender_name = str;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public String getReceiver_name() {
        return this.receiver_name;
    }

    public void setReceiver_name(String str) {
        this.receiver_name = str;
    }
}
