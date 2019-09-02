package com.subasta.model;

import java.io.Serializable;

public class SubscriptionPackageDTO implements Serializable {
    String auction_count;
    String created_at;
    String curr_pub_id;
    String currency_code;
    String package_name;
    String package_pub_id;
    String price;
    String status;
    String total_days;
    String updated_at;

    public SubscriptionPackageDTO() {
        String str = "";
        this.package_pub_id = str;
        this.package_name = str;
        this.price = str;
        this.curr_pub_id = str;
        this.auction_count = str;
        this.total_days = str;
        this.status = str;
        this.created_at = str;
        this.currency_code = str;
        this.updated_at = str;
    }

    public String getCurrency_code() {
        return this.currency_code;
    }

    public void setCurrency_code(String str) {
        this.currency_code = str;
    }

    public String getPackage_pub_id() {
        return this.package_pub_id;
    }

    public void setPackage_pub_id(String str) {
        this.package_pub_id = str;
    }

    public String getPackage_name() {
        return this.package_name;
    }

    public void setPackage_name(String str) {
        this.package_name = str;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public String getCurr_pub_id() {
        return this.curr_pub_id;
    }

    public void setCurr_pub_id(String str) {
        this.curr_pub_id = str;
    }

    public String getAuction_count() {
        return this.auction_count;
    }

    public void setAuction_count(String str) {
        this.auction_count = str;
    }

    public String getTotal_days() {
        return this.total_days;
    }

    public void setTotal_days(String str) {
        this.total_days = str;
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
}
