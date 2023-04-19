package kr.ac.kopo.library.book.ui;

import kr.ac.kopo.library.book.service.BookService;
import kr.ac.kopo.library.ui.BaseUI;

public abstract class BookBaseUI extends BaseUI {
	
	protected BookService service;

	protected BookBaseUI() {
		service = new BookService();
	}

	
	
}
