package edu.miu.test;

import java.util.List;
import java.util.Optional;

import edu.miu.dataaccess.LibraryMemberDAO;
import edu.miu.dataaccess.impl.LibraryMemberDAOImpl;
import edu.miu.dataaccess.impl.ObjectDAOFactory;
import edu.miu.domain.LibraryMember;

public class TestDataAccess {
	public static void main(String[] args) {

//		LibraryMember mem1 = new LibraryMember("123", "Manh Tien", "Dinh", "0123456", "N 4th St", "fairfield", "IA",
//				"52556");
//		LibraryMember mem2 = new LibraryMember("234", "AAAA", "DDDD", "6436", "XN 4th St", "BBBairfield", "IMMA",
//				"52556");
//		
//		LibraryMember mem3 = new LibraryMember("2349", "mmm", "asdasd", "dsgd", "AXN 4th St", "BBBairfield", "IMMA",
//				"52556");

		LibraryMemberDAO dao = ObjectDAOFactory.getLibraryMemberDAO();
//		dao.saveNewMember(mem1);
//		dao.saveNewMember(mem2);
//		dao.saveNewMember(mem3);

		List<LibraryMember> list = dao.getAllLibraryMember();
		for(int i = 0; i< list.size(); i++) {
			LibraryMember member = list.get(i);
			System.out.println("id: "+ member.getMemberId());
			System.out.println("fname: "+ member.getFirstName());
			System.out.println("lname: "+ member.getLastName());
			System.out.println("phone: "+ member.getPhone());
			System.out.println("city: "+ member.getAddress().getCity());
			System.out.println("state: "+ member.getAddress().getState());
			System.out.println("street: "+ member.getAddress().getStreet());
			System.out.println("zip: "+ member.getAddress().getZip());
		}
		Optional<LibraryMember> libraryMemberOpt = dao.getLibraryMemberById("2349");
		if (libraryMemberOpt.isPresent()) {
			LibraryMember libMember = libraryMemberOpt.get();
			System.out.println(libMember.getFirstName() + " - " + libMember.getAddress().getCity());
		}

	}
}
