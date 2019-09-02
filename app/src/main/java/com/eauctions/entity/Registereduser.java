package com.eauctions.entity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Registereduser implements Serializable {
	private static final long serialVersionUID = 1L;

	private String username;
	private List<Bidderrating> bidderratings;
	private List<Sellerrating> sellerratings;
	private Mailbox mailboxs;
	private List<Auction> auctions1;
	private List<Message> inboxMessages;
	private List<Message> outBoxMessages;
	private User user;
	private List<Auction> auctions2;

	public Registereduser() {
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Auction> getAuctions1() {
		return this.auctions1;
	}

	public void setAuctions1(List<Auction> auctions1) {
		this.auctions1 = auctions1;
	}

	public Auction addAuctions1(Auction auctions1) {
		if(this.auctions1 == null)
			this.auctions1 = new ArrayList<Auction>();
		
		getAuctions1().add(auctions1);
		auctions1.setRegistereduser(this);

		return auctions1;
	}

	public Auction removeAuctions1(Auction auctions1) {
		getAuctions1().remove(auctions1);
		auctions1.setRegistereduser(null);

		return auctions1;
	}

	public List<Message> getInboxMessages() {
		return this.inboxMessages;
	}

	public void setInboxMessages(List<Message> messages1) {
		this.inboxMessages = messages1;
	}

	public Message addInboxMessages(Message inboxMessage) {
		if(this.inboxMessages == null)
			inboxMessages = new ArrayList<Message>();
		getInboxMessages().add(inboxMessage);
		inboxMessage.setFromRegistereduser(this);

		return inboxMessage;
	}

	public Message removeInboxMessages(Message outBoxMessage) {
		getInboxMessages().remove(outBoxMessage);
		outBoxMessage.setFromRegistereduser(null);

		return outBoxMessage;
	}

	public List<Message> getOutBoxMessages() {
		return this.outBoxMessages;
	}

	public void setOutBoxMessages(List<Message> messages2) {
		this.outBoxMessages = messages2;
	}

	public Message addOutBoxMessages(Message outBoxMessage) {
		if(this.outBoxMessages == null)
			outBoxMessages = new ArrayList<Message>();
		getOutBoxMessages().add(outBoxMessage);
		outBoxMessage.setToRegistereduser(this);

		return outBoxMessage;
	}

	public Message removeOutBoxMessages(Message outBoxMessage) {
		getOutBoxMessages().remove(outBoxMessage);
		outBoxMessage.setToRegistereduser(null);

		return outBoxMessage;
	}
	
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Auction> getAuctions2() {
		return this.auctions2;
	}

	public void setAuctions2(List<Auction> auctions2) {
		this.auctions2 = auctions2;
	}
	
	public Mailbox getMailboxs() {
		return this.mailboxs;
	}

	public void setMailboxs(Mailbox mailboxs) {
		this.mailboxs = mailboxs;
	}
	
	public List<Bidderrating> getBidderratings() {
		return this.bidderratings;
	}

	public void setBidderratings(List<Bidderrating> bidderratings) {
		this.bidderratings = bidderratings;
	}

	public Bidderrating addBidderrating(Bidderrating bidderrating) {
		getBidderratings().add(bidderrating);
		bidderrating.setRegistereduser(this);

		return bidderrating;
	}

	public Bidderrating removeBidderrating(Bidderrating bidderrating) {
		getBidderratings().remove(bidderrating);
		bidderrating.setRegistereduser(null);

		return bidderrating;
	}

	public List<Sellerrating> getSellerratings() {
		return this.sellerratings;
	}

	public void setSellerratings(List<Sellerrating> sellerratings) {
		this.sellerratings = sellerratings;
	}

	public Sellerrating addSellerrating(Sellerrating sellerrating) {
		getSellerratings().add(sellerrating);
		sellerrating.setRegistereduser(this);

		return sellerrating;
	}

	public Sellerrating removeSellerrating(Sellerrating sellerrating) {
		getSellerratings().remove(sellerrating);
		sellerrating.setRegistereduser(null);

		return sellerrating;
	}

}
