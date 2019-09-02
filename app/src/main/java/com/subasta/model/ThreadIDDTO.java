package com.subasta.model;

import java.io.Serializable;

public class ThreadIDDTO implements Serializable {
    private String thread_id = "";

    public String getThread_id() {
        return this.thread_id;
    }

    public void setThread_id(String str) {
        this.thread_id = str;
    }
}
