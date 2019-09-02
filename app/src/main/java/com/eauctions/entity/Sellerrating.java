package com.eauctions.entity;

import java.io.Serializable;

public class Sellerrating implements Serializable {
	private static final long serialVersionUID = 1L;

	private SellerratingPK id;

	private int rate;

	private Registereduser registereduser;

	public Sellerrating() {
	}

	public SellerratingPK getId() {
		return this.id;
	}

	public void setId(SellerratingPK id) {
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
