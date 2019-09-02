package com.subasta.model;

import java.io.Serializable;
import java.util.ArrayList;

public class MyBidDTO implements Serializable {
    String auction_price;
    String bid_pub_id;
    String created_at;
    String currency_code;
    String image;
    ArrayList<AuncitonImageDTO> image_cust = new ArrayList<>();
    String price;
    String pro_pub_id;
    String status;
    String title;
    String updated_at;
    String user_pub_id;

    public MyBidDTO() {
        String str = "";
        this.bid_pub_id = str;
        this.pro_pub_id = str;
        this.user_pub_id = str;
        this.price = str;
        this.created_at = str;
        this.updated_at = str;
        this.status = str;
        this.title = str;
        this.currency_code = str;
        this.image = str;
        this.auction_price = str;
    }

    public ArrayList<AuncitonImageDTO> getImage_cust() {
        return this.image_cust;
    }

    public void setImage_cust(ArrayList<AuncitonImageDTO> arrayList) {
        this.image_cust = arrayList;
    }

    public String getAuction_price() {
        return this.auction_price;
    }

    public void setAuction_price(String str) {
        this.auction_price = str;
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

    public String getUser_pub_id() {
        return this.user_pub_id;
    }

    public void setUser_pub_id(String str) {
        this.user_pub_id = str;
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

    public String getUpdated_at() {
        return this.updated_at;
    }

    public void setUpdated_at(String str) {
        this.updated_at = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getCurrency_code() {
        return this.currency_code;
    }

    public void setCurrency_code(String str) {
        this.currency_code = str;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String str) {
        this.image = str;
    }
}
