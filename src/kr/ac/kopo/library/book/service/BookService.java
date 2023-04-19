package kr.ac.kopo.library.book.service;

import java.util.List;

import kr.ac.kopo.library.book.dao.BookDAO;
import kr.ac.kopo.library.book.vo.BookVO;

public class BookService {
	private BookDAO bookDao;

	public BookService() {
		bookDao = new BookDAO();
	}
	
	public List<BookVO> searchSelect(String search, String detail){
		return bookDao.searchSelect(search, detail);
	};
	
	
	public List<BookVO> selectAll(){
		return bookDao.selectAll();
	};
	
	
	public int insertBook(BookVO book) {
		return bookDao.insertBook(book);
	}
	
	public int updateBook(int b_no, String type, String change) {
		return bookDao.updateBook(b_no, type, change);
	}
	
	public int deleteBook(int b_no) {
		return bookDao.deleteBook(b_no);
	}
	
	


}
