package com.subasta.model;

import java.io.Serializable;

public class CurrentSubDTO implements Serializable {
    private String auction_count;
    private String currency_code;
    private String currency_type;
    private String end_date;
    private String invoice_id;
    private String package_name;
    private String start_date;
    private String total_price;

    public CurrentSubDTO() {
        String str = "";
        this.package_name = str;
        this.end_date = str;
        this.auction_count = str;
        this.invoice_id = str;
        this.total_price = str;
        this.start_date = str;
        this.currency_type = str;
        this.currency_code = str;
    }

    public String getCurrency_code() {
        return this.currency_code;
    }

    public void setCurrency_code(String str) {
        this.currency_code = str;
    }

    public String getPackage_name() {
        return this.package_name;
    }

    public void setPackage_name(String str) {
        this.package_name = str;
    }

    public String getEnd_date() {
        return this.end_date;
    }

    public void setEnd_date(String str) {
        this.end_date = str;
    }

    public String getAuction_count() {
        return this.auction_count;
    }

    public void setAuction_count(String str) {
        this.auction_count = str;
    }

    public String getInvoice_id() {
        return this.invoice_id;
    }

    public void setInvoice_id(String str) {
        this.invoice_id = str;
    }

    public String getTotal_price() {
        return this.total_price;
    }

    public void setTotal_price(String str) {
        this.total_price = str;
    }

    public String getStart_date() {
        return this.start_date;
    }

    public void setStart_date(String str) {
        this.start_date = str;
    }

    public String getCurrency_type() {
        return this.currency_type;
    }

    public void setCurrency_type(String str) {
        this.currency_type = str;
    }
}
