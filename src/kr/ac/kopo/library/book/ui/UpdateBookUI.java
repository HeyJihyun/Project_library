package kr.ac.kopo.library.book.ui;

import kr.ac.kopo.util.Line;

public class UpdateBookUI extends BookBaseUI {

	public int menu() {
		Line.line('_');
		System.out.println();
		System.out.println("\t1.제목수정 \t2.저자수정 \t3.출판사수정 \t4.분야수정 \t5.수정취소");
		Line.line('_');
		int select = scanInt("\n\t원하는 항목을 선택해 주세요 : ");
		return select;
	}

	@Override
	public void execute() throws Exception {
		
		System.out.println("\t_");
		System.out.println("\t도서수정");
		System.out.println("\t_");

		int b_no = scanInt("\t변경할 책 번호를 입력 \t:");
		String type = null;
		while (type == null) {
			switch (menu()) {
			case 1:
				type = "title";
				break;
			case 2:
				type = "writer";
				break;
			case 3:
				type = "publisher";
				break;
			case 4:
				type = "genre";
				break;
			case 5:
				return;
			default:
				System.out.println("\t - 잘못입력 하셨습니다.");
			}
		}
		
		String change = scanString("\t변경내용 \t\t: ");

		System.out.println();
		if(service.updateBook(b_no, type, change) == 1)
			System.out.println("\t 수정이 완료되었습니다.");
		else System.out.println("\t 수정에 실패하였습니다.");

	}
}
