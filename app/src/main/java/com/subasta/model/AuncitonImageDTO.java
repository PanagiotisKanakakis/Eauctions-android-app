package com.subasta.model;

import java.io.Serializable;

public class AuncitonImageDTO implements Serializable {

    /* renamed from: id */
    private String f1309id;
    private String image;

    public AuncitonImageDTO() {
        String str = "";
        this.image = str;
        this.f1309id = str;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String str) {
        this.image = str;
    }

    public String getId() {
        return this.f1309id;
    }

    public void setId(String str) {
        this.f1309id = str;
    }
}
