package com.subasta.model;

import java.io.Serializable;

public class SupportDTO implements Serializable {
    String created_at;
    String description;
    String status;
    String support_pub_id;
    String title;
    String updated_at;
    String user_pub_id;

    public SupportDTO() {
        String str = "";
        this.support_pub_id = str;
        this.user_pub_id = str;
        this.title = str;
        this.description = str;
        this.status = str;
        this.created_at = str;
        this.updated_at = str;
    }

    public String getSupport_pub_id() {
        return this.support_pub_id;
    }

    public void setSupport_pub_id(String str) {
        this.support_pub_id = str;
    }

    public String getUser_pub_id() {
        return this.user_pub_id;
    }

    public void setUser_pub_id(String str) {
        this.user_pub_id = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
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
