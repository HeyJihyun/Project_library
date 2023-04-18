package kr.ac.kopo.library.member.ui;

import kr.ac.kopo.library.member.service.MemberService;
import kr.ac.kopo.library.member.vo.MemberVO;
import kr.ac.kopo.library.ui.BaseUI;

public class ModifyMemberUI extends BaseUI {

	String id;
	MemberService service;

	public ModifyMemberUI(String id) {
		this.id = id;
		service = new MemberService();
	}

	private int menu() {
		System.out.println();
		System.out.println("1. 비밀번호 수정 2. 이름변경 3. 핸드폰 번호 수정 4. 이전페이지");
		return scanInt("원하는 항목을 선택해 주세요 : ");
	}
	
	// 회원정보 조회
	private void viewInfo() {
		System.out.println("=============================");
		System.out.println("\t\t회원정보");
		System.out.println("-----------------------------");
		MemberVO member = service.getMember(id);
		System.out.printf("아이디		: %s\n", member.getId());
		System.out.printf("이름		: %s\n", member.getName());
		System.out.printf("핸드폰번호	: %s\n", member.getPhone());
		System.out.println("=============================\n");
	}

	@Override
	public void execute() throws Exception {

		String pwd = scanString("비밀번호를 입력해주세요.");
		if (service.logIn(id, pwd)) {
			String type = null;

			while(true) {
				viewInfo();
				switch (menu()) {
				case 1:
					type = "pwd";
					break;
				case 2:
					type = "name";
					break;
				case 3:
					type = "name";
					break;
				case 4:
					return;
				}
				
				if (type != null) {
					String change = scanString("수정 내용 : ");
					int result = service.updateMember(id, type, change);
					if (result == 1) {
						System.out.println("수정이 완료되었습니다.");
					} else {
						System.out.println("수정에 실패하였습니다.");
					}
				} else {
					System.out.println("잘못입력 하셨습니다.");
				}
			}

		} else {
			System.out.println("잘못입력 하셨습니다.");
			execute();
		}
		;

	}

}
