package com.eauctions.entity;

import java.io.Serializable;


public class Mailbox implements Serializable {
	private static final long serialVersionUID = 1L;

	private MailboxPK id;
	private String type;
	private Message message;
	private Registereduser registereduser;

	public Mailbox() {
	}

	public MailboxPK getId() {
		return this.id;
	}

	public void setId(MailboxPK id) {
		this.id = id;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Message getMessage() {
		return this.message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public Registereduser getRegistereduser() {
		return this.registereduser;
	}

	public void setRegistereduser(Registereduser registereduser) {
		this.registereduser = registereduser;
	}

}
