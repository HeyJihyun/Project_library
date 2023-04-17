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
		
		System.out.println("========================================");
		System.out.println("\t\t검색 결과 페이지");
		System.out.println("========================================");
		System.out.println("no \t\t 제목 \t\t 저자 \t 출판일 \t 출판사 \t 분야");
		
		if(bookList == null || bookList.size() == 0) {
			System.out.println("검색 결과가 없습니다.");
		} else {
			for(BookVO book : bookList) {
				System.out.printf("%3d ", book.getB_no());
				System.out.printf("%20s", book.getTitle() );
				System.out.printf("%20s",book.getWriter());
				System.out.printf("%s", book.getPub_date() );
				System.out.printf("%10s", book.getPublisher());
				System.out.printf("%10s\n", book.getGenre());
			}
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		
	}
	

}
