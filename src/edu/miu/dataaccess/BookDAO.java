package edu.miu.dataaccess;
import java.util.List;
import java.util.Optional;

import edu.miu.domain.Book;
import edu.miu.domain.LibraryMember;

public interface BookDAO { 
	public List<Book> getAllBook();
	public Optional<Book> getBookById(String bookId);
	public void saveBook(Book book);
}
