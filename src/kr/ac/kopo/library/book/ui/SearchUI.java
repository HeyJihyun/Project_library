package kr.ac.kopo.library.book.ui;

import java.util.List;

import kr.ac.kopo.library.book.vo.BookVO;
import kr.ac.kopo.util.Line;

public class SearchUI extends BookBaseUI {
	


	private String search;
	private String detail;
	
	public SearchUI() {
		
	}
	
	public SearchUI(String search, String detail) {
		this.search = search;
		this.detail = detail;
	}

	@Override
	public void execute() throws Exception {
		List<BookVO> bookList = service.searchSelect(search, detail);
		
		System.out.println();
		Line.line('_');
		System.out.println("\n\t\t\t\t\t\t\t\t\t\t  검색 도서 조회\n");
		Line.line('_');
		System.out.printf("\n %-4s\t %-6s\t \t%-50s\t %-15s\t %-30s\t %-9s\t %-20s \n", "번호", "대여현황", "제목", "저자", "출판사", "출판월", "분야");
		Line.line('.');
		System.out.println();
		
		if(bookList == null || bookList.size() == 0) {
			System.out.println("\t검색 결과가 없습니다.");
		} else {
			for(BookVO book : bookList) {
				System.out.printf(" %03d \t ", book.getB_no());
				System.out.printf("%-6s \t", book.getR_state());
				System.out.printf("%-50s \t", book.getTitle() );
				System.out.printf("%-15s \t",book.getWriter());
				System.out.printf("%-30s \t", book.getPublisher());
				System.out.printf("%-9s \t", book.getPub_date() );
				System.out.printf("%-20s \n", book.getGenre());
			}
		}
		
		System.out.println();
		
		Line.line('_');
		System.out.println();
		
	}
	

}
