package com.subasta.model;

import java.io.Serializable;

public class ImageDTO implements Serializable {
    String image = "";

    public String getImage() {
        return this.image;
    }

    public void setImage(String str) {
        this.image = str;
    }
}
