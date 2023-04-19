package kr.ac.kopo.library.ui;

import kr.ac.kopo.library.member.ui.MemberCreateUI;
import kr.ac.kopo.library.member.ui.MemberSigninUI;
import kr.ac.kopo.util.Line;

public class MainMenuUI extends MenuUI {

	@Override
	public void execute() throws Exception {
		Line.line('_');
		System.out.println("\n\t\t\t\t\t\t\t\t\t\tJH도서관에 오신걸 환영합니다\n");
		while (true) {

			int select = menu("\t1.회원 로그인 \t\t2.회원가입 \t\t3.프로그램 종료");
			ILibraryUI ui = null;

			switch (select) {
			case 1:
				ui = new MemberSigninUI();
				break;
			case 2:
				ui = new MemberCreateUI();
				break;
			case 3: 
				ui = new ExitUI();
				break;
			}

			if (ui != null) {
				ui.execute();
			} else {
				System.out.println("잘못입력 하셨습니다.");
			}

		}
	}

}
