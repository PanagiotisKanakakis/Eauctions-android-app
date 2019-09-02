package com.subasta.model;

import java.io.Serializable;
import java.util.ArrayList;

public class WonBidDTO implements Serializable {
    String bid_pub_id;
    String created_at;
    String currency_code;
    String image;
    ArrayList<AuncitonImageDTO> image_cust = new ArrayList<>();
    String owner_user_pub_id;
    String price;
    String pro_price;
    String pro_pub_id;
    String title;
    String updated_at;
    String won_id;
    String won_user_pub_id;

    public WonBidDTO() {
        String str = "";
        this.won_id = str;
        this.owner_user_pub_id = str;
        this.won_user_pub_id = str;
        this.pro_pub_id = str;
        this.title = str;
        this.price = str;
        this.currency_code = str;
        this.image = str;
        this.bid_pub_id = str;
        this.pro_price = str;
        this.created_at = str;
        this.updated_at = str;
    }

    public String getBid_pub_id() {
        return this.bid_pub_id;
    }

    public void setBid_pub_id(String str) {
        this.bid_pub_id = str;
    }

    public String getPro_price() {
        return this.pro_price;
    }

    public void setPro_price(String str) {
        this.pro_price = str;
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

    public String getWon_id() {
        return this.won_id;
    }

    public void setWon_id(String str) {
        this.won_id = str;
    }

    public String getOwner_user_pub_id() {
        return this.owner_user_pub_id;
    }

    public void setOwner_user_pub_id(String str) {
        this.owner_user_pub_id = str;
    }

    public String getWon_user_pub_id() {
        return this.won_user_pub_id;
    }

    public void setWon_user_pub_id(String str) {
        this.won_user_pub_id = str;
    }

    public String getPro_pub_id() {
        return this.pro_pub_id;
    }

    public void setPro_pub_id(String str) {
        this.pro_pub_id = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String str) {
        this.price = str;
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

    public ArrayList<AuncitonImageDTO> getImage_cust() {
        return this.image_cust;
    }

    public void setImage_cust(ArrayList<AuncitonImageDTO> arrayList) {
        this.image_cust = arrayList;
    }
}
