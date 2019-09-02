package com.subasta.model;

import java.io.Serializable;

public class BidsDTO implements Serializable {
    String bid_pub_id;
    String created_at;
    String currency_code;
    String image;
    String iswin;
    String name;
    String price;
    String pro_pub_id;
    String user_pub_id;

    public BidsDTO() {
        String str = "";
        this.user_pub_id = str;
        this.bid_pub_id = str;
        this.pro_pub_id = str;
        this.price = str;
        this.created_at = str;
        this.name = str;
        this.image = str;
        this.currency_code = str;
        this.iswin = str;
    }

    public String getIswin() {
        return this.iswin;
    }

    public void setIswin(String str) {
        this.iswin = str;
    }

    public String getCurrency_code() {
        return this.currency_code;
    }

    public void setCurrency_code(String str) {
        this.currency_code = str;
    }

    public String getUser_pub_id() {
        return this.user_pub_id;
    }

    public void setUser_pub_id(String str) {
        this.user_pub_id = str;
    }

    public String getBid_pub_id() {
        return this.bid_pub_id;
    }

    public void setBid_pub_id(String str) {
        this.bid_pub_id = str;
    }

    public String getPro_pub_id() {
        return this.pro_pub_id;
    }

    public void setPro_pub_id(String str) {
        this.pro_pub_id = str;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public String getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(String str) {
        this.created_at = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String str) {
        this.image = str;
    }
}
