package kr.ac.kopo.library.member.ui;

import kr.ac.kopo.library.member.service.MemberService;
import kr.ac.kopo.library.member.vo.MemberVO;
import kr.ac.kopo.library.ui.BaseUI;

public class MemberSigninUI extends BaseUI {
	MemberService memberService = new MemberService();

	@Override
	public void execute() throws Exception {
		System.out.println("========================================");
		System.out.println("\t\t로그인 페이지");
		System.out.println("========================================");

		MemberVO member = new MemberVO();

		member.setId(scanString("아이디  : "));
		member.setPwd(scanString("비밀번호 : "));

		if (memberService.logIn(member)) {
			System.out.println("로그인 완료");
			new SubMain().execute();
		}
		else
			System.out.println("아이디 또는 비밀번호가 올바르지 않습니다.");
	}

}
