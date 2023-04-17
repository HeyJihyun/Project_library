package kr.ac.kopo.library.member.ui;

import kr.ac.kopo.library.member.service.MemberService;
import kr.ac.kopo.library.member.vo.MemberVO;
import kr.ac.kopo.library.ui.BaseUI;

public class MemberCreateUI extends BaseUI{
	
	MemberService memberService = new MemberService();

	@Override
	public void execute() throws Exception {
		
		System.out.println("========================================");
		System.out.println("\t\t회원가입 페이지");
		System.out.println("========================================");
		String id = scanString("id 입력 : ");
		
		while(memberService.checkId(id)) {
			System.out.println("중복된 아이디 입니다.");
			System.out.println();
			id = scanString("id 입력 : ");
		};
	
		String pwd = scanString("비밀번호 입력 : ");
		while(!pwd.equals(scanString("비밀번호 확인 : "))){
			System.out.println("비밀번호를 확인해 주세요.");
			pwd = scanString("비밀번호 입력 : ");
		} ;
		
		String name = scanString("이름 입력 : ");
		String phone = scanString("연락처 입력 : ");
		
		MemberVO member = new MemberVO(id, pwd, name, phone);
		
		memberService.insertMember(member);
		
	}

}
