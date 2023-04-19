package kr.ac.kopo.library.book.ui;

import kr.ac.kopo.library.ui.MenuUI;

public class SearchMenuUI extends MenuUI {

	@Override
	public void execute() throws Exception {

		int select = menu("\t1.제목으로 검색 \t2.저자로 검색 \t\t3.출판사로 검색 \t4.도서번호로 검색 \t5.이전페이지");
		String search = null;
		switch (select) {
		case 1:
			search = "TITLE";
			break;
		case 2:
			search = "WRITER";
			break;
		case 3:
			search = "PUBLISHER";
			break;
		case 4:
			search = "B_NO";
			break;
		case 5:
			return;
		}

		if (search != null) {
			String detail = scanString("\n\t" + search + " 검색 \t: ");
			new SearchUI(search, detail).execute();
		} else {
			System.out.println("\n\t - 잘못입력 하셨습니다.");
			this.execute();
		}

	}

}
