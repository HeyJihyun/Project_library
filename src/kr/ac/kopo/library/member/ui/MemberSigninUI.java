package kr.ac.kopo.library.member.ui;

import kr.ac.kopo.library.manager.service.ManagerService;
import kr.ac.kopo.library.manager.ui.ManagerMenuUI;
import kr.ac.kopo.library.ui.SubMemu;

public class MemberSigninUI extends MemeberBaseUI {

	@Override
	public void execute() throws Exception {
		System.out.println("\t_");
		String id = scanString("\n\t아이디 \t\t : ");
		String pwd = scanString("\t비밀번호 \t : ");
		System.out.println("\t_");
		

		if (service.logIn(id, pwd)) {
			System.out.println("\n\t로그인 완료");
			if(new ManagerService().managerCheck(id)) {
				new ManagerMenuUI(id).execute();
			} else {
				new SubMemu(id).execute();
			}
		}
		else
			System.out.println("\n\t아이디 또는 비밀번호가 올바르지 않습니다.");
	}

}
