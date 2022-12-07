package edu.miu.domain;

import java.io.Serializable;

public class Author extends Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1034856252760294933L;
	private String credentials;

	public Author(String firstName, String lastName, String phone, String street, String city, String state, String zip,
			String credentials) {
		this.credentials = credentials;
		setFirstName(firstName);
		setLastName(lastName);
		setPhone(phone);
		setAddress(new Address(street, city, state, zip));
	}

	public String getCredentials() {
		return credentials;
	}

	public void setCredentials(String credentials) {
		this.credentials = credentials;
	}

}
