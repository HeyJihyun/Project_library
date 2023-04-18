package kr.ac.kopo.library.book.ui;

import java.util.List;

import kr.ac.kopo.library.book.service.BookService;
import kr.ac.kopo.library.book.vo.BookVO;
import kr.ac.kopo.library.ui.BaseUI;

public class SearchUI extends BaseUI {
	
	BookService service = new BookService();


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
		
		System.out.println("====================================================================================");
		System.out.println("\t\t검색 결과 페이지");
		System.out.println("====================================================================================");
		System.out.printf(" %-4s %-4s %-7s %-10s %-10s %-10s %-30s \n", "번호", "대여현황", "출판월", "출판사", "분야", "출판사", "제목");
		System.out.println("------------------------------------------------------------------------------------");
		
		if(bookList == null || bookList.size() == 0) {
			System.out.println("검색 결과가 없습니다.");
		} else {
			for(BookVO book : bookList) {
				System.out.printf(" %03d  ", book.getB_no());
				System.out.printf("%-6s ", book.getR_state());
				System.out.printf("%-9s ", book.getPub_date() );
				System.out.printf("%-10s ", book.getPublisher());
				System.out.printf("%-10s ", book.getGenre());
				System.out.printf("%-10s ",book.getWriter());
				System.out.printf("%-30s \n", book.getTitle() );
			}
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		
	}
	

}
