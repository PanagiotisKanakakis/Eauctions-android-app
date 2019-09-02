package com.subasta.model;

import java.io.Serializable;
import java.util.ArrayList;

public class ViewAllAuctionDTO implements Serializable {
    String Allrating;
    String address;
    ArrayList<BidsDTO> bids = new ArrayList<>();
    String brand_id;
    String cat_id;
    String cat_title;
    String created_at;
    String currency_code;
    String description;
    String e_date;
    String favourite;
    ArrayList<GalleryDTO> gallery = new ArrayList<>();
    String gallery_count;

    /* renamed from: id */
    String f1319id;
    String image;
    String insured;
    String latitude;
    String longitude;
    String model_id;
    String no_of_owner;
    String price;
    String pro_pub_id;
    String rating;
    String s_date;
    String sub_cat_id;
    String title;
    String updated_at;
    String user_pub_id;
    UserDTO users;

    public ViewAllAuctionDTO() {
        String str = "";
        this.f1319id = str;
        this.pro_pub_id = str;
        this.user_pub_id = str;
        this.title = str;
        this.brand_id = str;
        this.model_id = str;
        this.image = str;
        this.cat_id = str;
        this.sub_cat_id = str;
        this.price = str;
        this.address = str;
        this.latitude = str;
        this.longitude = str;
        this.description = str;
        this.s_date = str;
        this.e_date = str;
        this.no_of_owner = str;
        this.insured = str;
        this.created_at = str;
        this.updated_at = str;
        this.currency_code = str;
        this.gallery_count = str;
        this.favourite = str;
        this.Allrating = str;
        this.rating = str;
        this.cat_title = str;
    }

    public String getCat_title() {
        return this.cat_title;
    }

    public void setCat_title(String str) {
        this.cat_title = str;
    }

    public String getAllrating() {
        return this.Allrating;
    }

    public void setAllrating(String str) {
        this.Allrating = str;
    }

    public String getRating() {
        return this.rating;
    }

    public void setRating(String str) {
        this.rating = str;
    }

    public String getId() {
        return this.f1319id;
    }

    public void setId(String str) {
        this.f1319id = str;
    }

    public String getPro_pub_id() {
        return this.pro_pub_id;
    }

    public void setPro_pub_id(String str) {
        this.pro_pub_id = str;
    }

    public String getUser_pub_id() {
        return this.user_pub_id;
    }

    public void setUser_pub_id(String str) {
        this.user_pub_id = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getBrand_id() {
        return this.brand_id;
    }

    public void setBrand_id(String str) {
        this.brand_id = str;
    }

    public String getModel_id() {
        return this.model_id;
    }

    public void setModel_id(String str) {
        this.model_id = str;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String str) {
        this.image = str;
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

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String str) {
        this.price = str;
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getS_date() {
        return this.s_date;
    }

    public void setS_date(String str) {
        this.s_date = str;
    }

    public String getE_date() {
        return this.e_date;
    }

    public void setE_date(String str) {
        this.e_date = str;
    }

    public String getNo_of_owner() {
        return this.no_of_owner;
    }

    public void setNo_of_owner(String str) {
        this.no_of_owner = str;
    }

    public String getInsured() {
        return this.insured;
    }

    public void setInsured(String str) {
        this.insured = str;
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

    public String getCurrency_code() {
        return this.currency_code;
    }

    public void setCurrency_code(String str) {
        this.currency_code = str;
    }

    public String getGallery_count() {
        return this.gallery_count;
    }

    public void setGallery_count(String str) {
        this.gallery_count = str;
    }

    public String getFavourite() {
        return this.favourite;
    }

    public void setFavourite(String str) {
        this.favourite = str;
    }

    public UserDTO getUsers() {
        return this.users;
    }

    public void setUsers(UserDTO userDTO) {
        this.users = userDTO;
    }

    public ArrayList<BidsDTO> getBids() {
        return this.bids;
    }

    public void setBids(ArrayList<BidsDTO> arrayList) {
        this.bids = arrayList;
    }

    public ArrayList<GalleryDTO> getGallery() {
        return this.gallery;
    }

    public void setGallery(ArrayList<GalleryDTO> arrayList) {
        this.gallery = arrayList;
    }
}
