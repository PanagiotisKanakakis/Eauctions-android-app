package com.subasta.model;

import java.io.Serializable;

public class NotificationDTO implements Serializable {
    String created_at;
    String message;
    String notication_id;
    String pro_pub_id;
    String tittle;
    String type;
    String updated_at;
    String user_pub_id;

    public NotificationDTO() {
        String str = "";
        this.notication_id = str;
        this.tittle = str;
        this.user_pub_id = str;
        this.message = str;
        this.created_at = str;
        this.updated_at = str;
        this.type = str;
        this.pro_pub_id = str;
    }

    public String getPro_pub_id() {
        return this.pro_pub_id;
    }

    public void setPro_pub_id(String str) {
        this.pro_pub_id = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getNotication_id() {
        return this.notication_id;
    }

    public void setNotication_id(String str) {
        this.notication_id = str;
    }

    public String getTittle() {
        return this.tittle;
    }

    public void setTittle(String str) {
        this.tittle = str;
    }

    public String getUser_pub_id() {
        return this.user_pub_id;
    }

    public void setUser_pub_id(String str) {
        this.user_pub_id = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(String str) {
        this.created_at = str;
    }

    public String getUpdated_at() {
        return this.updated_at;
    }

    public void setUpdated_at(String str) {
        this.updated_at = str;
    }
}
