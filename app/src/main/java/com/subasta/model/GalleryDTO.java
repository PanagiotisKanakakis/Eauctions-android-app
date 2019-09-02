package com.subasta.model;

import java.io.Serializable;

public class GalleryDTO implements Serializable {
    String created_at;

    /* renamed from: id */
    String f1314id;
    String image;
    String pro_pub_id;
    String updated_at;

    public GalleryDTO() {
        String str = "";
        this.f1314id = str;
        this.pro_pub_id = str;
        this.image = str;
        this.created_at = str;
        this.updated_at = str;
    }

    public String getId() {
        return this.f1314id;
    }

    public void setId(String str) {
        this.f1314id = str;
    }

    public String getPro_pub_id() {
        return this.pro_pub_id;
    }

    public void setPro_pub_id(String str) {
        this.pro_pub_id = str;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String str) {
        this.image = str;
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
