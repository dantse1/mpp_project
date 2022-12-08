package edu.miu.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Book implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 337077152840623485L;
	private String isbn;
	private String title;
	private int maxCheckoutLength;//in day
	private List<BookCopy> bookcopies;
	private List<Author> authors;

	public Book(String isbn, String title, int maxCheckoutLength, int numCopies) {
		this.isbn = isbn;
		this.title = title;
		this.maxCheckoutLength = maxCheckoutLength;
		bookcopies = new ArrayList<BookCopy>();
		authors = new ArrayList();
		
		bookcopies.add(new BookCopy(this, 1, true));
		if (numCopies > 1) {
			for (int i = 1; i <= numCopies; i++) {
				bookcopies.add(new BookCopy(this, i + 1, true));
			}
		}

	}
	
	public void addAuthor(Author author) {
		this.authors.add(author);
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getMaxCheckoutLength() {
		return maxCheckoutLength;
	}

	public void setMaxCheckoutLength(int maxCheckoutLength) {
		this.maxCheckoutLength = maxCheckoutLength;
	}

	public List<BookCopy> getBookcopies() {
		return bookcopies;
	}

	public void setBookcopies(List<BookCopy> bookcopies) {
		this.bookcopies = bookcopies;
	}

}
