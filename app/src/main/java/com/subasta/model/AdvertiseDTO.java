package com.subasta.model;

import java.io.Serializable;

public class AdvertiseDTO implements Serializable {
    String add_pro_id;
    String category;
    String created_at;
    String description;
    String image;
    String price;
    String status;
    String title;

    public AdvertiseDTO() {
        String str = "";
        this.image = str;
        this.category = str;
        this.title = str;
        this.price = str;
        this.created_at = str;
        this.add_pro_id = str;
        this.status = str;
        this.description = str;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String str) {
        this.image = str;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String str) {
        this.category = str;
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

    public String getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(String str) {
        this.created_at = str;
    }

    public String getAdd_pro_id() {
        return this.add_pro_id;
    }

    public void setAdd_pro_id(String str) {
        this.add_pro_id = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }
}
