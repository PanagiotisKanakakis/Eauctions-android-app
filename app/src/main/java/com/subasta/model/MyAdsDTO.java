package com.subasta.model;

import java.io.Serializable;

public class MyAdsDTO implements Serializable {
    String productduration;
    int productimage;
    String productname;
    String productprice;

    public MyAdsDTO(String str, String str2, String str3, int i) {
        this.productname = str;
        this.productduration = str2;
        this.productprice = str3;
        this.productimage = i;
    }

    public String getProductname() {
        return this.productname;
    }

    public void setProductname(String str) {
        this.productname = str;
    }

    public String getProductduration() {
        return this.productduration;
    }

    public void setProductduration(String str) {
        this.productduration = str;
    }

    public String getProductprice() {
        return this.productprice;
    }

    public void setProductprice(String str) {
        this.productprice = str;
    }

    public int getProductimage() {
        return this.productimage;
    }

    public void setProductimage(int i) {
        this.productimage = i;
    }
}
