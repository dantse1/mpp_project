package edu.miu.service;

import edu.miu.dataaccess.impl.ObjectDAOFactory;
import edu.miu.domain.Book;

import java.util.List;
import java.util.Optional;

import edu.miu.dataaccess.BookDAO;

public class BookService {
	private static BookService service = new BookService();

	public static BookService getService() {
		return service;
	}

	private BookDAO bookDAO = ObjectDAOFactory.getBookDAO();

	public Optional<Book> getBookById(String isbn) {
		return bookDAO.getBookById(isbn);
	}
	
	public Book saveBook(Book book) {
		bookDAO.saveBook(book);
		return book;
	}
	
	public void addBook(String isbn, String title, int maxCheckoutLength, int numCopies) {
		Book book = new Book(isbn, title, maxCheckoutLength,numCopies);
		bookDAO.saveBook(book);
	}
	
	public List<Book> getAllBooks(){
		return bookDAO.getAllBook();
	}
}
