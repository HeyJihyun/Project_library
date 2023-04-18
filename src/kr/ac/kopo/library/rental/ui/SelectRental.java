package kr.ac.kopo.library.rental.ui;

import kr.ac.kopo.library.rental.service.RentalService;
import kr.ac.kopo.library.rental.vo.RentalVO;
import kr.ac.kopo.library.ui.BaseUI;

public class SelectRental  extends BaseUI {
	String id;
	RentalService service;
	
	public SelectRental(String id) {
		this.id = id;
		service = new RentalService();
	}


	@Override
	public void execute() throws Exception {

		int lental = scanInt("대여할 도서 번호입력 (0입력 시 이전 페이지 이동) : ");
		RentalVO vo = new RentalVO();
		
		switch(lental) {
		case 0 : return;
		default : 
			vo.setB_no(lental);
			vo.setU_id(id);
		}
		
	
		service.insertRental(vo);
		
	}
}
