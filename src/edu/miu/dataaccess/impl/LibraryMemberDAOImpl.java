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

public class LibraryMemberDAOImpl implements LibraryMemberDAO {
	public static final String OUTPUT_DIR = System.getProperty("user.dir") + File.separator + "src" + File.separator
			+ "edu" + File.separator + "miu" + File.separator + "storage";
	
	LibraryMemberDAOImpl(){
		
	}

	@Override
	public void saveNewMember(LibraryMember member) {
		HashMap<String, LibraryMember> mems = readMemberMap();
		String memberId = member.getMemberId();
		mems.put(memberId, member);
		saveToStorage(StorageType.MEMBERS, mems);
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
		HashMap<String, LibraryMember> hm = (HashMap<String, LibraryMember>) readFromStorage(StorageType.MEMBERS);
		if (null == hm) { // data file not found
			hm = new HashMap<String, LibraryMember>();
		}
		return hm;
	}

	static void saveToStorage(StorageType type, Object ob) {
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, type.toString());
			System.out.println("save to " + path.toAbsolutePath());
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(ob);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e) {
				}
			}
		}
	}

	static Object readFromStorage(StorageType type) {
		ObjectInputStream in = null;
		Object retVal = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, type.toString());
			in = new ObjectInputStream(Files.newInputStream(path));
			retVal = in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
				}
			}
		}
		return retVal;
	}
}
