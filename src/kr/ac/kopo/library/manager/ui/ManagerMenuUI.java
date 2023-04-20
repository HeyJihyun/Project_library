package kr.ac.kopo.library.manager.ui;

import kr.ac.kopo.library.book.ui.InsertBookUI;
import kr.ac.kopo.library.book.ui.DeleteBookUI;
import kr.ac.kopo.library.book.ui.UpdateBookUI;
import kr.ac.kopo.library.book.ui.ViewAllUI;
import kr.ac.kopo.library.member.service.MemberService;
import kr.ac.kopo.library.member.ui.MemberAllUI;
import kr.ac.kopo.library.ui.ILibraryUI;
import kr.ac.kopo.library.ui.MenuUI;

public class ManagerMenuUI extends MenuUI {
	
	String id;
	MemberService memberService = null;
	
	public ManagerMenuUI(String id) {
		this.id = id;
		memberService = new MemberService();
	}

	@Override
	public void execute() throws Exception {
		while (true) {
			int select = menu("\t1. 전체도서 조회 \t2. 도서 등록 \t\t3. 도서정보 수정 \t4. 도서 삭제 \t5. 전체회원조회 \t6.로그아웃");
			ILibraryUI ui = null;

			switch (select) {
			case 1:
				ui = new ViewAllUI();
				break; 
			case 2:
				ui = new InsertBookUI();
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
				System.out.println("\t잘못입력 하셨습니다.");
			}

		}
		
	}
	

}
