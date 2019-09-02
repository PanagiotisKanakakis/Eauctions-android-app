package com.eauctions.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Auction implements Serializable {
	private static final long serialVersionUID = 1L;

	private int auctionID;

	private float buyPrice;

	private Date expirationDate;

	private float firstBid;

	private Date startedTime;

	private String title;


	private Product product;


	private Registereduser registereduser;


	private List<Registereduser> registeredusers = new ArrayList<Registereduser>();

	public Auction() {}

	public int getAuctionID() {
		return this.auctionID;
	}

	public void setAuctionID(int auctionID) {
		this.auctionID = auctionID;
	}

	public float getBuyPrice() {
		return this.buyPrice;
	}

	public void setBuyPrice(float buyPrice) {
		this.buyPrice = buyPrice;
	}

	public Date getExpirationDate() {
		return this.expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public float getFirstBid() {
		return this.firstBid;
	}

	public void setFirstBid(float firstBid) {
		this.firstBid = firstBid;
	}

	public Date getStartedTime() {
		return this.startedTime;
	}

	public void setStartedTime(Date startedTime) {
		this.startedTime = startedTime;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Registereduser getRegistereduser() {
		return this.registereduser;
	}

	public void setRegistereduser(Registereduser registereduser) {
		this.registereduser = registereduser;
	}

	public List<Registereduser> getRegisteredusers() {
		return this.registeredusers;
	}

	public void setRegisteredusers(List<Registereduser> registeredusers) {
		this.registeredusers = registeredusers;
	}

}
