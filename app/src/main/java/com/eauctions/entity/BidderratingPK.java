package com.eauctions.entity;

import java.io.Serializable;

/**
 * The primary key class for the bidderrating database table.
 * 
 */
public class BidderratingPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int ratingID;

	private String username;

	public BidderratingPK() {
	}
	public int getRatingID() {
		return this.ratingID;
	}
	public void setRatingID(int ratingID) {
		this.ratingID = ratingID;
	}
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BidderratingPK)) {
			return false;
		}
		BidderratingPK castOther = (BidderratingPK)other;
		return 
			(this.ratingID == castOther.ratingID)
			&& this.username.equals(castOther.username);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.ratingID;
		hash = hash * prime + this.username.hashCode();
		
		return hash;
	}
}
