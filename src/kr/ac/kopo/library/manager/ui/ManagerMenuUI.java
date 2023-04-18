package kr.ac.kopo.library.manager.ui;

import kr.ac.kopo.library.book.ui.UpdateBookUI;
import kr.ac.kopo.library.book.ui.ViewAllUI;
import kr.ac.kopo.library.book.ui.CreateBookUI;
import kr.ac.kopo.library.book.ui.DeleteBookUI;
import kr.ac.kopo.library.member.service.MemberService;
import kr.ac.kopo.library.member.ui.MemberAllUI;
import kr.ac.kopo.library.ui.BaseUI;
import kr.ac.kopo.library.ui.ILibraryUI;

public class ManagerMenuUI extends BaseUI {
	
	String id;
	MemberService memberService = null;
	
	public ManagerMenuUI(String id) {
		this.id = id;
		memberService = new MemberService();
	}

	public int menu() {
		System.out.println();
		System.out.println("1. 전체도서 조회 2. 도서 등록 3. 도서정보 수정 4. 도서 삭제 5. 전체회원조회 6.로그아웃");
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
				ui = new ViewAllUI();
				break; 
			case 2:
				ui = new CreateBookUI();
				break;
			case 3: 
				ui = new UpdateBookUI();
 				break;
			case 4: 
				ui = new DeleteBookUI();
				break;
			case 5: 
				ui = new MemberAllUI();
				break;
			case 6: 
				return;
			}

			if (ui != null) {
				ui.execute();
			} else {
				System.out.println("잘못입력 하셨습니다.");
			}

		}
		
	}
	

}
