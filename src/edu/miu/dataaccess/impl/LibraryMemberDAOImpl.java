package edu.miu.dataaccess.impl;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import edu.miu.dataaccess.LibraryMemberDAO;
import edu.miu.domain.LibraryMember;
import edu.miu.util.StorageUtils;

public class LibraryMemberDAOImpl implements LibraryMemberDAO {
	
	LibraryMemberDAOImpl(){
		
	}

	@Override
	public void saveNewMember(LibraryMember member) {
		HashMap<String, LibraryMember> mems = readMemberMap();
		String memberId = member.getMemberId();
		mems.put(memberId, member);
		StorageUtils.saveToStorage(StorageType.MEMBERS, mems);
	}

	@Override
	public List<LibraryMember> getAllLibraryMember() {
		HashMap<String, LibraryMember> map = readMemberMap();
		List<LibraryMember> list = new ArrayList<LibraryMember>(map.values());
		return list;
	}

	@Override
	public Optional<LibraryMember> getLibraryMemberById(String memberId) {
		HashMap<String, LibraryMember> map = readMemberMap();
		LibraryMember member = map.get(memberId);
		if (null != member) {
			return Optional.of(member);
		} else {
			return Optional.empty();
		}
	}

	@SuppressWarnings("unchecked")
	public HashMap<String, LibraryMember> readMemberMap() {
		// Returns a Map with name/value pairs being
		// memberId -> LibraryMember
		HashMap<String, LibraryMember> hm = (HashMap<String, LibraryMember>) StorageUtils.readFromStorage(StorageType.MEMBERS);
		if (null == hm) { // data file not found
			hm = new HashMap<String, LibraryMember>();
		}
		return hm;
	}
}
