package kr.ac.kopo.library.book.ui;

public class DeleteBookUI extends BookBaseUI {


	@Override
	public void execute() throws Exception {
		
		System.out.println("\t_");
		System.out.println("\t도서삭제");
		System.out.println("\t_");
		
		int b_no = scanInt("\t삭제할 책 번호 \t: ");
		switch (scanInt("\t정말 삭제하시려면 1번을 눌러주세요.(그 외 이전페이지)")) {
		case 1:
			int retult = service.deleteBook(b_no);
			System.out.println("\t" + retult + "권의 책을 삭제하였습니다.\n");
			System.out.println();
			break;
		default:
			return;
		}
		
	}
}
