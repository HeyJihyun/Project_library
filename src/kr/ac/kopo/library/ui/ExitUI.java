package kr.ac.kopo.library.ui;

public class ExitUI extends BaseUI {

	@Override
	public void execute() throws Exception{
		
		System.out.println("-----------------------------------");
		System.out.println("\t도서관 프로그램을 종료합니다");
		System.out.println("-----------------------------------");
		System.exit(0);
		
	}
	

}
