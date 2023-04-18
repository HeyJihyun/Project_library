package kr.ac.kopo.library.book.ui;

import kr.ac.kopo.library.book.service.BookService;
import kr.ac.kopo.library.ui.BaseUI;

public class UpdateBookUI extends BaseUI {
	BookService service = new BookService();

	public int menu() {
		System.out.println("1. 제목수정 2. 저자수정 3.출판사수정 4.분야수정 5.수정취소");
		int select = scanInt("원하는 항목을 선택해 주세요 : ");

		return select;
	}

	@Override
	public void execute() throws Exception {

		int b_no = scanInt("변경할 책 번호를 입력해 주세요");
		String type = null;
		while (type == null) {

			switch (menu()) {
			case 1:
				type = "title";
				break;
			case 2:
				type = "writer";
				break;
			case 3:
				type = "publisher";
				break;
			case 4:
				type = "genre";
				break;
			case 5:
				return;
			default:
				System.out.println("잘못입력 하셨습니다.");
			}
		}
		
		String change = scanString("변경내용 : ");

		service.updateBook(b_no, type, change);

	}
}
