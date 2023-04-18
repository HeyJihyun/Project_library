package kr.ac.kopo.library.book.ui;

import kr.ac.kopo.library.book.service.BookService;
import kr.ac.kopo.library.book.vo.BookVO;
import kr.ac.kopo.library.ui.BaseUI;

public class CreateBookUI extends BaseUI {
	BookService service = new BookService();

	@Override
	public void execute() throws Exception {
		
		BookVO book = new BookVO();
		book.setTitle(scanString("책 제목 : "));
		book.setWriter(scanString("저자 : "));
		book.setPub_date(scanString("출판월(yyyy-mm) : "));
		book.setPublisher(scanString("출판사 : "));
		book.setGenre(scanString("장르 : "));
		
		System.out.println(service.insertBook(book) + "권의 도서 등록을 완료 하였습니다.");
		System.out.println("\n");
	}
	

}
