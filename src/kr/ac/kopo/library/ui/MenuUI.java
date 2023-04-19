package kr.ac.kopo.library.ui;

import kr.ac.kopo.util.Line;

// 메뉴 출력 클래스
public abstract class MenuUI extends BaseUI{
	
	protected int menu(String msg) {
		

		Line.line('_');
		System.out.println();
		System.out.println(msg);
		Line.line('_');
		int select = scanInt("\n\t원하는 항목을 선택해 주세요 : ");
		System.out.println();
		return select;

	}
}
