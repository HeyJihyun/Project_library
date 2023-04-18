package kr.ac.kopo.library.member.ui;

import java.util.List;

import kr.ac.kopo.library.member.service.MemberService;
import kr.ac.kopo.library.member.vo.MemberVO;
import kr.ac.kopo.library.ui.BaseUI;

public class MemberAllUI extends BaseUI {

	MemberService service = new MemberService();

	@Override
	public void execute() throws Exception {
		List<MemberVO> memberList = service.selectAll();

		System.out.println("========================================");
		System.out.println("\t\t전체 회원 페이지");
		System.out.println("========================================");
		System.out.println("아이디 \t\t 이름 \t\t 연락처 \t 등급");

		if (memberList == null || memberList.size() == 0) {
			System.out.println("회원 목록이 없습니다.");
		} else {
			for (MemberVO member : memberList) {
				System.out.printf("%s ", member.getId());
				System.out.printf("%s ", member.getName());
				System.out.printf("%s ", member.getPhone());
				System.out.printf("%s \n", member.getGrade());
			}
		}
		
		
	}
}
