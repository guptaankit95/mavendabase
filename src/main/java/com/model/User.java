package com.model;

public class User {

	private String userName;
	private int id;

	public User(String userName, int id) {

		this.userName = userName;
		this.id = id;
	}

	public User() {

	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
