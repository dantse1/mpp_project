package edu.miu.domain;

import java.io.Serializable;

public class LibraryMember extends Person implements Serializable, Comparable<LibraryMember> {
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
	
	@Override
	public int compareTo(LibraryMember u) {
		if (getMemberId() == null || u.getMemberId() == null) {
			return 0;
		}
		return -getMemberId().compareTo(u.getMemberId());
	}
}
