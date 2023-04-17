package kr.ac.kopo.library;

import kr.ac.kopo.library.ui.MainUI;

public class LibraryMain {
	public static void main(String[] args) {

		
		try {
			new MainUI().execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
