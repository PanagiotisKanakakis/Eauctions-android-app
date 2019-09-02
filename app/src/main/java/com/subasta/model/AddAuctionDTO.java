package com.subasta.model;

public class AddAuctionDTO {
    String address;
    String cat_id;
    String description;
    String e_date;
    String image;
    String insured;
    String latitude;
    String longitude;
    String no_of_owner;
    String price;
    String s_date;
    String title;

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

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public void setLatitude(String str) {
        this.latitude = str;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public void setLongitude(String str) {
        this.longitude = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getS_date() {
        return this.s_date;
    }

    public void setS_date(String str) {
        this.s_date = str;
    }

    public String getE_date() {
        return this.e_date;
    }

    public void setE_date(String str) {
        this.e_date = str;
    }

    public String getNo_of_owner() {
        return this.no_of_owner;
    }

    public void setNo_of_owner(String str) {
        this.no_of_owner = str;
    }

    public String getInsured() {
        return this.insured;
    }

    public void setInsured(String str) {
        this.insured = str;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String str) {
        this.image = str;
    }

    public String getCat_id() {
        return this.cat_id;
    }

    public void setCat_id(String str) {
        this.cat_id = str;
    }
}
