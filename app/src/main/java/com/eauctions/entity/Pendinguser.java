package com.eauctions.entity;

import java.io.Serializable;


public class Pendinguser implements Serializable {
	private static final long serialVersionUID = 1L;
	private String username;
	private User user;

	public Pendinguser() {}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
