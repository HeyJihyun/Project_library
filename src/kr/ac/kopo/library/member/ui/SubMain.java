package kr.ac.kopo.library.member.ui;

import kr.ac.kopo.library.book.ui.SearchMenuUI;
import kr.ac.kopo.library.book.ui.ViewAllUI;
import kr.ac.kopo.library.rental.ui.SelectRental;
import kr.ac.kopo.library.ui.BaseUI;
import kr.ac.kopo.library.ui.ExitUI;
import kr.ac.kopo.library.ui.ILibraryUI;
import kr.ac.kopo.library.ui.MainUI;

public class SubMain extends BaseUI {
	private int menu() {
		System.out.println("1.도서검색 2.전체도서 조회 3.대여도서 선택 4.마이페이지 5.로그아웃 6.프로그램 종료");
		int select = scanInt("원하는 항목을 선택해 주세요 : ");

		return select;
	}

	@Override
	public void execute() throws Exception {

		int select = menu();
		ILibraryUI ui = null;

		switch (select) {
		case 1:
			ui = new SearchMenuUI();
			break;
		case 2:
			ui = new ViewAllUI();
			break;
		case 3:
			ui = new MypageUI();
			break;
		case 4:
			ui = new SelectRental();
			break;
		case 5:
			ui = new MainUI();
			break;
		case 6:
			ui = new ExitUI();
			break;
		}

		if (ui != null) {
			ui.execute();
		} else {
			System.out.println("잘못입력 하셨습니다.");
			execute();
		}

	}

}
