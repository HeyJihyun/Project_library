package kr.ac.kopo.library.member.ui;

import kr.ac.kopo.library.member.service.MemberService;
import kr.ac.kopo.library.ui.BaseUI;
import kr.ac.kopo.library.ui.MainUI;

public class DeactivateUI extends BaseUI {
	
	String id;
	MemberService service;

	public DeactivateUI(String id) {
		this.id = id;
		service = new MemberService();
	}

	@Override
	public void execute() throws Exception {
		char type = scanString("정말로 탈퇴하시겠습니까? (y/n)").charAt(0);
		switch (type) {
		case 'y':
			String pwd = scanString("비밀번호를 입력해주세요.");
			if (service.logIn(id, pwd)) {
				if(service.delete(id) != 0) {
					System.out.println("탈퇴가 완료되었습니다.");
					new MainUI().execute();
				} else { 
					
				};
			} else {
				System.out.println("잘못입력 하셨습니다.");
				execute();
			}
			break;
		default: return;
		}
		
		
	}
}
