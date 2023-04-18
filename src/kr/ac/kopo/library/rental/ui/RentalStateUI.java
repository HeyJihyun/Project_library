package kr.ac.kopo.library.rental.ui;

import java.util.List;

import kr.ac.kopo.library.rental.service.RentalService;
import kr.ac.kopo.library.rental.vo.RentalVO;
import kr.ac.kopo.library.ui.BaseUI;
import kr.ac.kopo.library.ui.ILibraryUI;

public class RentalStateUI extends BaseUI {

	String id;
	RentalService service;

	public RentalStateUI(String id) {
		this.id = id;
		service = new RentalService();
	}

	private int menu() {
		System.out.println();
		System.out.println("1. 반납하기 2. 연장하기 3. 이전페이지");
		return scanInt("원하는 항목을 선택해 주세요 : ");
	}

	public void getRState() {
		List<RentalVO> rentalList = service.getRState(id);

		System.out.println("\n=======================================================");
		System.out.println("\t\t\t대여 목록 페이지");
		System.out.println("-------------------------------------------------------");
		System.out.println("no   연장여부 \t 대여일 \t 반납일 \t 제목");

		if (rentalList == null || rentalList.size() == 0) {
			System.out.println("대여 목록이 없습니다.");
		} else {
			for (RentalVO rental : rentalList) {
				System.out.printf("%03d ", rental.getB_no());
				System.out.printf("%-6s ", rental.getExtension() == 1 ? "연장가능" : "연장불가");
				System.out.printf("%-12s ", rental.getRental_date());
				System.out.printf("%-12s ", rental.getReturn_date());
				System.out.printf("%s \n", rental.getTitle());
			}
		}
		System.out.println("=======================================================\n");
	}

	@Override
	public void execute() throws Exception {
		
		while (true) {
			getRState();
			int select = menu();
			ILibraryUI ui = null;
			switch (select) {
			case 1:
				ui = new ReturnBookUI(id);
				break;
			case 2:
				ui = new ExtensionUI(id);
				break;
			case 3:
				return;
			}

			if (ui != null) {
				ui.execute();
			} else {
				System.out.println("잘못입력 하셨습니다.");
			}
		}
	}
}
