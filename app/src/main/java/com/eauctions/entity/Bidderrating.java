package com.eauctions.entity;

import java.io.Serializable;

public class Bidderrating implements Serializable {
	private static final long serialVersionUID = 1L;

	private BidderratingPK id;
	private int rate;
	private Registereduser registereduser;

	public Bidderrating() {
	}

	public BidderratingPK getId() {
		return this.id;
	}

	public void setId(BidderratingPK id) {
		this.id = id;
	}

	public int getRate() {
		return this.rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public Registereduser getRegistereduser() {
		return this.registereduser;
	}

	public void setRegistereduser(Registereduser registereduser) {
		this.registereduser = registereduser;
	}

}
