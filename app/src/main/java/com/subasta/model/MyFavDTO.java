package com.subasta.model;

import java.io.Serializable;
import java.util.ArrayList;

public class MyFavDTO implements Serializable {
    String created_at;
    String currency_code;

    /* renamed from: id */
    String f1317id;
    String image;
    ArrayList<AuncitonImageDTO> image_cust = new ArrayList<>();
    String isFavourite;
    String price;
    String pro_pub_id;
    String title;

    public MyFavDTO() {
        String str = "";
        this.f1317id = str;
        this.pro_pub_id = str;
        this.isFavourite = str;
        this.title = str;
        this.price = str;
        this.currency_code = str;
        this.image = str;
        this.created_at = str;
    }

    public ArrayList<AuncitonImageDTO> getImage_cust() {
        return this.image_cust;
    }

    public void setImage_cust(ArrayList<AuncitonImageDTO> arrayList) {
        this.image_cust = arrayList;
    }

    public String getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(String str) {
        this.created_at = str;
    }

    public String getId() {
        return this.f1317id;
    }

    public void setId(String str) {
        this.f1317id = str;
    }

    public String getPro_pub_id() {
        return this.pro_pub_id;
    }

    public void setPro_pub_id(String str) {
        this.pro_pub_id = str;
    }

    public String getIsFavourite() {
        return this.isFavourite;
    }

    public void setIsFavourite(String str) {
        this.isFavourite = str;
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
}
