package com.subasta.model;

import java.io.Serializable;

public class AuctionImageDTO implements Serializable {

    /* renamed from: id */
    public long f1308id;
    public String name;
    public String path;

    public AuctionImageDTO(long j, String str, String str2) {
        this.f1308id = j;
        this.name = str;
        this.path = str2;
    }

    public long getId() {
        return this.f1308id;
    }

    public void setId(long j) {
        this.f1308id = j;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String str) {
        this.path = str;
    }
}
