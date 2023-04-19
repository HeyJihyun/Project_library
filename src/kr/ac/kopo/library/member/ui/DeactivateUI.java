package kr.ac.kopo.library.member.ui;

import kr.ac.kopo.library.ui.MainMenuUI;

public class DeactivateUI extends MemeberBaseUI {
	
	String id;

	public DeactivateUI(String id) {
		this.id = id;
	}

	@Override
	public void execute() throws Exception {
		char type = scanString("\t정말로 탈퇴하시겠습니까? (y/n)").charAt(0);
		System.out.println();
		switch (type) {
		case 'y':
			String pwd = scanString("\t비밀번호를 입력 \t: ");
			System.out.println();
			if (service.logIn(id, pwd)) {
				if(service.delete(id) != 0) {
					System.out.println("\t탈퇴가 완료되었습니다.");
					new MainMenuUI().execute();
				}
			} else {
				System.out.println("\t잘못입력 하셨습니다.");
				execute();
			}
			break;
		default: return;
		}
		
		
	}
}
