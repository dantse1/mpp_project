package edu.miu.service;

import edu.miu.dataaccess.BookDAO;
import edu.miu.dataaccess.impl.ObjectDAOFactory;
import edu.miu.domain.Book;

public class BookService {
	private BookDAO bookDAO; 
	
	public BookService() {
		bookDAO = ObjectDAOFactory.getBookDAO();
	}
	public void addBook(String isbn, String title, int maxCheckoutLength, int numCopies) {
		Book book = new Book(isbn, title, maxCheckoutLength,numCopies);
		bookDAO.saveNewBook(book);
	}
	
//	public BookDAO getBookDAO() {
//		return this.bookDAO;
//	}
}
