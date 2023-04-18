package kr.ac.kopo.library.rental.ui;

import kr.ac.kopo.library.rental.service.RentalService;
import kr.ac.kopo.library.ui.BaseUI;

public class ReturnBookUI extends BaseUI {
	
	String id;
	RentalService service;

	public ReturnBookUI(String id) {
		this.id = id;
		this.service = new RentalService();
	}

	@Override
	public void execute() throws Exception {
		
		int b_no = scanInt("\n반납할 도서 번호를 입력 : ");
		System.out.println(service.returnRental(id, b_no) + "권의 도서반납을 완료하였습니다.");
		
		
		
	}
}
