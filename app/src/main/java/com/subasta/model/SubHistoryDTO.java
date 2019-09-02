package com.subasta.model;

import java.io.Serializable;

public class SubHistoryDTO implements Serializable {
    private String created_at;
    private String curr_pub_id;
    private String currency_code;
    private String currency_type;
    private String discount;
    private String end_date;
    private String final_price;
    private String invoice_id;
    private String package_name;
    private String package_pub_id;
    private String start_date;
    private String status;
    private String tax;
    private String total_price;
    private String updated_at;
    private String user_pub_id;

    public SubHistoryDTO() {
        String str = "";
        this.invoice_id = str;
        this.package_pub_id = str;
        this.user_pub_id = str;
        this.curr_pub_id = str;
        this.discount = str;
        this.total_price = str;
        this.final_price = str;
        this.tax = str;
        this.start_date = str;
        this.end_date = str;
        this.status = str;
        this.created_at = str;
        this.updated_at = str;
        this.package_name = str;
        this.currency_type = str;
        this.currency_code = str;
    }

    public String getCurrency_code() {
        return this.currency_code;
    }

    public void setCurrency_code(String str) {
        this.currency_code = str;
    }

    public String getInvoice_id() {
        return this.invoice_id;
    }

    public void setInvoice_id(String str) {
        this.invoice_id = str;
    }

    public String getPackage_pub_id() {
        return this.package_pub_id;
    }

    public void setPackage_pub_id(String str) {
        this.package_pub_id = str;
    }

    public String getUser_pub_id() {
        return this.user_pub_id;
    }

    public void setUser_pub_id(String str) {
        this.user_pub_id = str;
    }

    public String getCurr_pub_id() {
        return this.curr_pub_id;
    }

    public void setCurr_pub_id(String str) {
        this.curr_pub_id = str;
    }

    public String getDiscount() {
        return this.discount;
    }

    public void setDiscount(String str) {
        this.discount = str;
    }

    public String getTotal_price() {
        return this.total_price;
    }

    public void setTotal_price(String str) {
        this.total_price = str;
    }

    public String getFinal_price() {
        return this.final_price;
    }

    public void setFinal_price(String str) {
        this.final_price = str;
    }

    public String getTax() {
        return this.tax;
    }

    public void setTax(String str) {
        this.tax = str;
    }

    public String getStart_date() {
        return this.start_date;
    }

    public void setStart_date(String str) {
        this.start_date = str;
    }

    public String getEnd_date() {
        return this.end_date;
    }

    public void setEnd_date(String str) {
        this.end_date = str;
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

    public String getPackage_name() {
        return this.package_name;
    }

    public void setPackage_name(String str) {
        this.package_name = str;
    }

    public String getCurrency_type() {
        return this.currency_type;
    }

    public void setCurrency_type(String str) {
        this.currency_type = str;
    }
}
