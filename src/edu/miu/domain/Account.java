package edu.miu.domain;

public class Account {

	private String role;
	private String userID;
	private String password;

	public Account(String role, String userID, String password) {
		super();
		this.role = role;
		this.userID = userID;
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public String getUserID() {
		return userID;
	}

	public String getPassword() {
		return password;
	}

}
