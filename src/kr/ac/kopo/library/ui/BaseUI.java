package kr.ac.kopo.library.ui;

import java.util.Scanner;

public abstract class BaseUI implements ILibraryUI{
	
	private Scanner sc;

	
	public BaseUI() {
		sc = new Scanner(System.in);

	}
	
	protected int scanInt(String msg) {
		return Integer.parseInt(scanString(msg));
	}
	
	protected String scanString(String msg) {
		System.out.print(msg);
		return sc.nextLine();
	}

}
