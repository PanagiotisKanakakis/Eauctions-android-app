package com.subasta.model;

import java.io.Serializable;

public class UpdateProfileDTO implements Serializable {
    String address;
    String city;
    String country;
    String country_code;
    String created_at;
    String device_token;
    String device_type;
    String email;
    String email_verified;
    String gender;
    String image;
    String latitude;
    String longitude;
    String mobile_no;
    String name;
    String password;
    String postcode;
    String status;
    String updated_at;
    String user_pub_id;
    String verify_email_token;

    public UpdateProfileDTO() {
        String str = "";
        this.user_pub_id = str;
        this.name = str;
        this.email = str;
        this.password = str;
        this.country = str;
        this.city = str;
        this.address = str;
        this.latitude = str;
        this.longitude = str;
        this.postcode = str;
        this.gender = str;
        this.country_code = str;
        this.image = str;
        this.email_verified = str;
        this.verify_email_token = str;
        this.device_token = str;
        this.created_at = str;
        this.updated_at = str;
        this.mobile_no = str;
        this.device_type = str;
        this.status = str;
    }

    public String getUser_pub_id() {
        return this.user_pub_id;
    }

    public void setUser_pub_id(String str) {
        this.user_pub_id = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public void setLatitude(String str) {
        this.latitude = str;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public void setLongitude(String str) {
        this.longitude = str;
    }

    public String getPostcode() {
        return this.postcode;
    }

    public void setPostcode(String str) {
        this.postcode = str;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String str) {
        this.gender = str;
    }

    public String getCountry_code() {
        return this.country_code;
    }

    public void setCountry_code(String str) {
        this.country_code = str;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String str) {
        this.image = str;
    }

    public String getEmail_verified() {
        return this.email_verified;
    }

    public void setEmail_verified(String str) {
        this.email_verified = str;
    }

    public String getVerify_email_token() {
        return this.verify_email_token;
    }

    public void setVerify_email_token(String str) {
        this.verify_email_token = str;
    }

    public String getDevice_token() {
        return this.device_token;
    }

    public void setDevice_token(String str) {
        this.device_token = str;
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

    public String getMobile_no() {
        return this.mobile_no;
    }

    public void setMobile_no(String str) {
        this.mobile_no = str;
    }

    public String getDevice_type() {
        return this.device_type;
    }

    public void setDevice_type(String str) {
        this.device_type = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
