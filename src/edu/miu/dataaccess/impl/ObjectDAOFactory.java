package edu.miu.dataaccess.impl;

import edu.miu.dataaccess.BookDAO;
import edu.miu.dataaccess.LibraryMemberDAO;

public class ObjectDAOFactory {
	
	private static LibraryMemberDAO libraryMemberDAO = new LibraryMemberDAOImpl();
	
	public static LibraryMemberDAO getLibraryMemberDAO() {
		return libraryMemberDAO;
	}
	
	private static BookDAO bookDAO = new BookDAOImpl();
	
	public static BookDAO getBookDAO() {
		return bookDAO;
	}

}
