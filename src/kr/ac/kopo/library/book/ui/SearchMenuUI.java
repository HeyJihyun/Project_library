package kr.ac.kopo.library.book.ui;

import kr.ac.kopo.library.ui.BaseUI;
import kr.ac.kopo.library.ui.ExitUI;

public class SearchMenuUI extends BaseUI {
	private int menu() {
		System.out.println("1.제목으로 검색 2.저자로 검색 3.출판사로 검색 4.도서번호로 검색 5.프로그램 종료");
		int select = scanInt("원하는 항목을 선택해 주세요 : ");

		return select;
	}

	@Override
	public void execute() throws Exception {

		int select = menu();
		String search = null;
		switch (select) {
		case 1:
			search = "title";
			break;
		case 2:
			search = "writer";
			break;
		case 3:
			search = "PUBLISHER";
			break;
		case 4:
			search = "B_NO";
			break;
		case 5:
			new ExitUI().execute();
			break;
		}

		if (search != null) {
			String detail = scanString(search + " 검색 : ");
			new SearchUI(search, detail).execute();
		} else {
			System.out.println("잘못입력 하셨습니다.");
			this.execute();
		}

	}

}
