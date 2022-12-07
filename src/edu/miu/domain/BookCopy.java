package edu.miu.domain;

import java.io.Serializable;

public class BookCopy implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8728209527486207870L;
	private int copyNumber;
	private Book book;
	private Boolean isAvailable;

	BookCopy(Book book, int copyNumber, Boolean isAvailable) {
		this.book = book;
		this.copyNumber = copyNumber;
		this.isAvailable = isAvailable;
	}

	public int getCopyNumber() {
		return copyNumber;
	}

	public Book getBook() {
		return book;
	}

	public Boolean getIsAvailable() {
		return isAvailable;
	}
}
