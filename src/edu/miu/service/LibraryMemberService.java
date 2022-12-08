package edu.miu.service;

import java.util.Collections;
import java.util.List;

import edu.miu.dataaccess.LibraryMemberDAO;
import edu.miu.dataaccess.impl.ObjectDAOFactory;
import edu.miu.domain.LibraryMember;

public class LibraryMemberService {
	private static LibraryMemberService service = new LibraryMemberService();
	public static LibraryMemberService getService() {
		return service;
	}
	
	private LibraryMemberDAO libraryMemberDAO = ObjectDAOFactory.getLibraryMemberDAO();
	
	public LibraryMember createNewLibraryMember(String firstName, String lastName, String phone, String street, String city, String state, String zip) {
		// generate id
		String memberId = "mem-"+String.format("%05d", (libraryMemberDAO.getAllLibraryMember().size() + 1));
		LibraryMember libraryMember = new LibraryMember(memberId, firstName, lastName, phone, street, city, state, zip);
		libraryMemberDAO.saveNewMember(libraryMember);
		return libraryMember;
	}
	
	public List<LibraryMember> getAllLibraryMember(){
		List<LibraryMember> list = libraryMemberDAO.getAllLibraryMember();
		Collections.sort(list);
		return list;
	}
}
