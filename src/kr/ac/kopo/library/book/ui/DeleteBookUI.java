package kr.ac.kopo.library.book.ui;

import kr.ac.kopo.library.book.service.BookService;
import kr.ac.kopo.library.ui.BaseUI;

public class DeleteBookUI extends BaseUI {

	BookService service = new BookService();

	@Override
	public void execute() throws Exception {
		
		int b_no = scanInt("삭제할 책 번호 : ");
		switch (scanInt("정말 삭제하시려면 1번을 눌러주세요.(그 외 이전페이지)")) {
		case 1:
			int retult = service.deleteBook(b_no);
			System.out.println(retult + "권의 책을 삭제하였습니다.\n");
			System.out.println();
			break;
		default:
			return;
		}
		
	}
}
