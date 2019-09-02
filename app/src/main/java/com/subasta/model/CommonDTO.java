package com.subasta.model;

import java.io.Serializable;

public class CommonDTO implements Serializable {
    private String catName;

    /* renamed from: id */
    private String f1312id;

    public CommonDTO(String str, String str2) {
        this.f1312id = str;
        this.catName = str2;
    }

    public String getId() {
        return this.f1312id;
    }

    public void setId(String str) {
        this.f1312id = str;
    }

    public String getCatName() {
        return this.catName;
    }

    public void setCatName(String str) {
        this.catName = str;
    }

    public String toString() {
        return this.catName.toString();
    }
}
