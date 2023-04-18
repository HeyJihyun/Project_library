package kr.ac.kopo.library.rental.ui;

import kr.ac.kopo.library.rental.service.RentalService;
import kr.ac.kopo.library.ui.BaseUI;

public class ExtensionUI  extends BaseUI {
	
	String id;
	RentalService service;
	
	public ExtensionUI(String id) {
		this.id = id;
		service = new RentalService();
	}
	@Override
	public void execute() throws Exception {
		int b_no = scanInt("\n연장할 도서 번호 입력 : ");
		int cnt = service.extension(id, b_no);
		if(cnt== 1) {
			System.out.println("반납일이 일주일 연장 되었습니다.");
		} else {
			System.out.println("연장에 실패하였습니다. 연장가능 여부를 확인해 주세요.");
		};
	}
}
