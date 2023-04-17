package kr.ac.kopo.library.ui;

import kr.ac.kopo.library.manager.ui.ManagerSigninUI;
import kr.ac.kopo.library.member.ui.MemberCreateUI;
import kr.ac.kopo.library.member.ui.MemberSigninUI;

public class MainUI extends BaseUI {

	private int menu() {
		System.out.println("1. 회원 로그인 2. 회원가입 3. 관리자페이지 4. 프로그램 종료");
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
				ui = new MemberSigninUI();
				break;
			case 2:
				ui = new MemberCreateUI();
				break;
			case 3:
				ui = new ManagerSigninUI();
				break;
			case 4:
				ui = new ExitUI();
				break;
			}

			if (ui != null) {
				ui.execute();
			} else {
				System.out.println("잘못입력 하셨습니다.");
				execute();
			}

		}
	}

}
