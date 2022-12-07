package edu.miu.domain;

import java.io.Serializable;

public class LibraryMember extends Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3301349362259195139L;
	
	private String memberId;
	
	public LibraryMember(String memberId, String firstName, String lastName, String phone, String street, String city, String state, String zip) {
		this.memberId = memberId;
		setFirstName(firstName);
		setLastName(lastName);
		setPhone(phone);
		setAddress(new Address(street, city, state, zip));
	}
	
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
}
