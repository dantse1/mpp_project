package edu.miu.dataaccess.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import edu.miu.dataaccess.BookDAO;
import edu.miu.domain.Book;
import edu.miu.util.StorageUtils;

public class BookDAOImpl implements BookDAO {

	@Override
	public List<Book> getAllBook() {
		HashMap<String, Book> books = readBookMap();
		return new ArrayList<Book>(books.values());
	}

	@Override
	public Optional<Book> getBookById(String bookId) {
		HashMap<String, Book> books = readBookMap();
		Book book = books.get(bookId);
		
		if(null != book) {
			return Optional.of(book);
		}
		
		return Optional.empty();
	}

	@Override
	public void saveBook(Book book) {

		HashMap<String, Book> books = readBookMap();
		books.put(book.getIsbn(), book);
		StorageUtils.saveToStorage(StorageType.BOOKS, books);
		
	}
	
	public HashMap<String, Book> readBookMap(){
		HashMap<String, Book> books = (HashMap<String, Book>) StorageUtils.readFromStorage(StorageType.BOOKS);
		
		if(null == books) {
			books = new HashMap<String, Book>();
		}
		return books;
	}

}
