package com.eauctions.entity;

import java.io.Serializable;


public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private String username;
	private int bidderRating;
	private int sellerRating;
	private String e_mail;
	private String name;
	private String password;
	private String phone_number;
	private String surname;
	private String trn;
	private Pendinguser pendinguser;
	private Registereduser registereduser;
	private Address address;

	public User() {}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getE_mail() {
		return this.e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone_number() {
		return this.phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getTrn() {
		return this.trn;
	}

	public void setTrn(String trn) {
		this.trn = trn;
	}

	public Pendinguser getPendinguser() {
		return this.pendinguser;
	}

	public void setPendinguser(Pendinguser pendinguser) {
		this.pendinguser = pendinguser;
	}

	public Registereduser getRegistereduser() {
		return this.registereduser;
	}

	public void setRegistereduser(Registereduser registereduser) {
		this.registereduser = registereduser;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public int getBidderRating() {
		return this.bidderRating;
	}

	public void setBidderRating(int bidRating) {
		this.bidderRating = bidRating;
	}
	
	public int getSellerRating() {
		return this.sellerRating;
	}

	public void setSellerRating(int sellerRating) {
		this.sellerRating = sellerRating;
	}

}
