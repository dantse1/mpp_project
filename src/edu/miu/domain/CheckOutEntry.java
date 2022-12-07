package edu.miu.domain;

import java.io.Serializable;
import java.time.LocalDate;

public class CheckOutEntry implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5163785557798176815L;
	private LocalDate checkoutDate;
	private LocalDate dueDate;
	private BookCopy bookCopy;

	CheckOutEntry(BookCopy bookCopy) {
		this.checkoutDate = LocalDate.now();
		this.dueDate = LocalDate.now().plusDays(bookCopy.getBook().getMaxCheckoutLength());
	}

	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public BookCopy getBookCopy() {
		return bookCopy;
	}

}
