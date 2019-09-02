package com.eauctions.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Message implements Serializable {
	private static final long serialVersionUID = 1L;
	private int messageID;
	private Date dateCreated;
	private int isRead;
	private String messageText;
	private String subject;
	private List<Mailbox> mailboxs;
	private Registereduser fromRegistereduser;
	private Registereduser toRegistereduser;

	public Message() {
	}

	public int getMessageID() {
		return this.messageID;
	}

	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public int getIsRead() {
		return this.isRead;
	}

	public void setIsRead(int isRead) {
		this.isRead = isRead;
	}

	public String getMessageText() {
		return this.messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public List<Mailbox> getMailboxs() {
		return this.mailboxs;
	}

	public void setMailboxs(List<Mailbox> mailboxs) {
		this.mailboxs = mailboxs;
	}

	public Mailbox addMailbox(Mailbox mailbox) {
		getMailboxs().add(mailbox);
		mailbox.setMessage(this);

		return mailbox;
	}

	public Mailbox removeMailbox(Mailbox mailbox) {
		getMailboxs().remove(mailbox);
		mailbox.setMessage(null);

		return mailbox;
	}

	public Registereduser getFromRegistereduser() {
		return this.fromRegistereduser;
	}

	public void setFromRegistereduser(Registereduser registereduser1) {
		this.fromRegistereduser = registereduser1;
	}

	public Registereduser getToRegistereduser() {
		return this.toRegistereduser;
	}

	public void setToRegistereduser(Registereduser registereduser2) {
		this.toRegistereduser = registereduser2;
	}

}
