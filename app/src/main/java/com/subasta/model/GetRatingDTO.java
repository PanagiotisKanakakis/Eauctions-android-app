package com.subasta.model;

import java.io.Serializable;

public class GetRatingDTO implements Serializable {
    private String comment;
    private String created_at;
    private String name;
    private String pro_pub_id;
    private String rating_id;
    private String star;
    private String status;
    private String updated_at;
    private String user_image;
    private String user_pub_id;

    public GetRatingDTO() {
        String str = "";
        this.rating_id = str;
        this.pro_pub_id = str;
        this.user_pub_id = str;
        this.star = str;
        this.comment = str;
        this.status = str;
        this.created_at = str;
        this.updated_at = str;
        this.user_image = str;
        this.name = str;
    }

    public String getUser_image() {
        return this.user_image;
    }

    public void setUser_image(String str) {
        this.user_image = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getRating_id() {
        return this.rating_id;
    }

    public void setRating_id(String str) {
        this.rating_id = str;
    }

    public String getPro_pub_id() {
        return this.pro_pub_id;
    }

    public void setPro_pub_id(String str) {
        this.pro_pub_id = str;
    }

    public String getUser_pub_id() {
        return this.user_pub_id;
    }

    public void setUser_pub_id(String str) {
        this.user_pub_id = str;
    }

    public String getStar() {
        return this.star;
    }

    public void setStar(String str) {
        this.star = str;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String str) {
        this.comment = str;
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
