package com.subasta.model;

import java.io.Serializable;

public class CategoryDTO implements Serializable {
    String cat_desc;
    String cat_id;
    String cat_title;
    String created_at;
    String image;
    String status;
    String updated_at;

    public CategoryDTO() {
        String str = "";
        this.cat_id = str;
        this.cat_title = str;
        this.cat_desc = str;
        this.image = str;
        this.status = str;
        this.updated_at = str;
        this.created_at = str;
    }

    public String getCat_id() {
        return this.cat_id;
    }

    public void setCat_id(String str) {
        this.cat_id = str;
    }

    public String getCat_title() {
        return this.cat_title;
    }

    public void setCat_title(String str) {
        this.cat_title = str;
    }

    public String getCat_desc() {
        return this.cat_desc;
    }

    public void setCat_desc(String str) {
        this.cat_desc = str;
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

    public String getUpdated_at() {
        return this.updated_at;
    }

    public void setUpdated_at(String str) {
        this.updated_at = str;
    }

    public String getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(String str) {
        this.created_at = str;
    }
}
