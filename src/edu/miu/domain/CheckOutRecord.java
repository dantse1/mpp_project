package edu.miu.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CheckOutRecord implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7735297522447600335L;
	private LibraryMember libraryMember;
	private Account account; // which librarian
	private List<CheckOutEntry> checkOutEntry;

	public CheckOutRecord(LibraryMember libraryMember, Account account) {
		this.libraryMember = libraryMember;
		this.account = account;
		checkOutEntry = new ArrayList<CheckOutEntry>();
	}

	public void addBookCopy(BookCopy bookCopy) {
		checkOutEntry.add(new CheckOutEntry(bookCopy));
	}

	public LibraryMember getLibraryMember() {
		return libraryMember;
	}

	public void setLibraryMember(LibraryMember libraryMember) {
		this.libraryMember = libraryMember;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<CheckOutEntry> getCheckOutEntry() {
		return checkOutEntry;
	}

	public void setCheckOutEntry(List<CheckOutEntry> checkOutEntry) {
		this.checkOutEntry = checkOutEntry;
	}
}
