package com.subasta.model;

import java.io.Serializable;

public class SubCategoryDTO implements Serializable {
    String cat_id;
    String created_at;
    String image;
    String status;
    String sub_cat_id;
    String sub_cat_title;
    String updated_at;

    public SubCategoryDTO(String str) {
        String str2 = "";
        this.cat_id = str2;
        this.sub_cat_id = str2;
        this.sub_cat_title = str2;
        this.image = str2;
        this.status = str2;
        this.created_at = str2;
        this.updated_at = str2;
        this.sub_cat_title = str;
    }

    public String getCat_id() {
        return this.cat_id;
    }

    public void setCat_id(String str) {
        this.cat_id = str;
    }

    public String getSub_cat_id() {
        return this.sub_cat_id;
    }

    public void setSub_cat_id(String str) {
        this.sub_cat_id = str;
    }

    public String getSub_cat_title() {
        return this.sub_cat_title;
    }

    public void setSub_cat_title(String str) {
        this.sub_cat_title = str;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String str) {
        this.image = str;
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

    public String toString() {
        return this.sub_cat_title.toString();
    }
}
