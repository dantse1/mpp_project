package edu.miu.dataaccess;
import java.util.List;
import java.util.Optional;

import edu.miu.domain.LibraryMember;

public interface LibraryMemberDAO { 
	public List<LibraryMember> getAllLibraryMember();
	public Optional<LibraryMember> getLibraryMemberById(String memberId);
	public void saveNewMember(LibraryMember member);
}
