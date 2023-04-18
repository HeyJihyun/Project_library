package kr.ac.kopo.library.member.ui;

import kr.ac.kopo.library.manager.service.ManagerService;
import kr.ac.kopo.library.manager.ui.ManagerMenuUI;
import kr.ac.kopo.library.member.service.MemberService;
import kr.ac.kopo.library.ui.BaseUI;

public class MemberSigninUI extends BaseUI {
	MemberService memberService = new MemberService();

	@Override
	public void execute() throws Exception {
		System.out.println();
		System.out.println("========================================");
		System.out.println("\t\t로그인 페이지");
		System.out.println("========================================");

		String id = scanString("아이디  : ");
		String pwd = scanString("비밀번호 : ");

		if (memberService.logIn(id, pwd)) {
			System.out.println("로그인 완료");
			if(new ManagerService().managerCheck(id)) {
				new ManagerMenuUI(id).execute();
			} else {
				new SubMain(id).execute();
			}
		}
		else
			System.out.println("아이디 또는 비밀번호가 올바르지 않습니다.");
	}

}
