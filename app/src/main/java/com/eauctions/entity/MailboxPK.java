package com.eauctions.entity;

import java.io.Serializable;


public class MailboxPK implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String registeredUser;
	private int messageID;

	public MailboxPK() {
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRegisteredUser() {
		return this.registeredUser;
	}
	public void setRegisteredUser(String registeredUser) {
		this.registeredUser = registeredUser;
	}
	public int getMessageID() {
		return this.messageID;
	}
	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MailboxPK)) {
			return false;
		}
		MailboxPK castOther = (MailboxPK)other;
		return 
			(this.id == castOther.id)
			&& this.registeredUser.equals(castOther.registeredUser)
			&& (this.messageID == castOther.messageID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.registeredUser.hashCode();
		hash = hash * prime + this.messageID;
		
		return hash;
	}
}
