package com.subasta.model;

import java.io.Serializable;

public class SubBrandsDTO implements Serializable {
    String brand_id;
    String brand_name;
    String cat_id;
    String sub_cat_id;

    public SubBrandsDTO(String str) {
        String str2 = "";
        this.brand_id = str2;
        this.cat_id = str2;
        this.sub_cat_id = str2;
        this.brand_name = str2;
        this.brand_name = str;
    }

    public String getBrand_id() {
        return this.brand_id;
    }

    public void setBrand_id(String str) {
        this.brand_id = str;
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

    public String getBrand_name() {
        return this.brand_name;
    }

    public void setBrand_name(String str) {
        this.brand_name = str;
    }

    public String toString() {
        return this.brand_name.toString();
    }
}
