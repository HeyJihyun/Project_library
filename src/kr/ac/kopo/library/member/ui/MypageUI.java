package kr.ac.kopo.library.member.ui;

import kr.ac.kopo.library.rental.ui.RentalStateUI;
import kr.ac.kopo.library.ui.BaseUI;
import kr.ac.kopo.library.ui.ILibraryUI;

public class MypageUI extends BaseUI {

	String id;

	public MypageUI(String id) {
		this.id = id;
	}

	private int menu() {
		System.out.println();
		System.out.println("1. 대여현황 2. 회원정보수정 3. 회원탈퇴 4. 이전페이지");
		int select = scanInt("원하는 항목을 선택해 주세요 : ");

		return select;
	}

	@Override
	public void execute() throws Exception {
		while (true) {
			int select = menu();
			ILibraryUI ui = null;

			switch (select) {
			case 1:
				ui = new RentalStateUI(id);
				break;
			case 2:
				ui = new ModifyMemberUI(id);
				break;
			case 3:
				ui = new DeactivateUI(id);
				break;
			case 4:
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
