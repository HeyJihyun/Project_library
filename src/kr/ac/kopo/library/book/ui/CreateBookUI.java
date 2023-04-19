package kr.ac.kopo.library.book.ui;

import kr.ac.kopo.library.book.vo.BookVO;

public class CreateBookUI extends BookBaseUI {

	@Override
	public void execute() throws Exception {
		
		System.out.println("\t_");
		System.out.println("\t도서등록");
		System.out.println("\t_");
		
		BookVO book = new BookVO();
		book.setTitle(scanString("\t책 제목 \t\t: "));
		book.setWriter(scanString("\t저자 \t: "));
		book.setPub_date(scanString("\t출판월(yyyy-mm) \t: "));
		book.setPublisher(scanString("\t출판사 \t\t: "));
		book.setGenre(scanString("\t장르 \t\t: "));
		
		System.out.println();
		System.out.println("\t" + service.insertBook(book) + "권의 도서 등록을 완료 하였습니다.");
		System.out.println("\n");
	}
	

}
