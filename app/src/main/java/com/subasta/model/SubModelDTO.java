package com.subasta.model;

import java.io.Serializable;

public class SubModelDTO implements Serializable {
    String brand_id;
    String cat_id;
    String model_id;
    String model_name;
    String sub_cat_id;

    public SubModelDTO(String str) {
        String str2 = "";
        this.model_id = str2;
        this.cat_id = str2;
        this.sub_cat_id = str2;
        this.brand_id = str2;
        this.model_name = str2;
        this.model_name = str;
    }

    public String getModel_id() {
        return this.model_id;
    }

    public void setModel_id(String str) {
        this.model_id = str;
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

    public String getBrand_id() {
        return this.brand_id;
    }

    public void setBrand_id(String str) {
        this.brand_id = str;
    }

    public String getModel_name() {
        return this.model_name;
    }

    public void setModel_name(String str) {
        this.model_name = str;
    }

    public String toString() {
        return this.model_name.toString();
    }
}
