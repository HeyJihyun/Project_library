package kr.ac.kopo.library.rental.ui;

import kr.ac.kopo.library.rental.vo.RentalVO;

public class SelectRental  extends RentalBaseUI {
	
	String id;
	
	public SelectRental(String id) {
		this.id = id;
	}


	@Override
	public void execute() throws Exception {

		System.out.println("\t_\n");
		int lental = scanInt("\t대여할 도서 번호입력 (0입력 시 이전 페이지 이동) : ");
		RentalVO vo = new RentalVO();
		
		switch(lental) {
		case 0 : return;
		default : 
			vo.setB_no(lental);
			vo.setU_id(id);
		}

		if(service.insertRental(vo) == 1) {
			System.out.println("\n\t" + lental + "번 도서 대여를 완료하였습니다.");
		}

	
		
	}
}
