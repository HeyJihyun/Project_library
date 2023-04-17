package kr.ac.kopo.library.book.service;

import java.util.List;

import kr.ac.kopo.library.book.DAO.BookDAO;
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
	
	
	


}
