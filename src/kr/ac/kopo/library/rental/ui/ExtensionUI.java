package kr.ac.kopo.library.rental.ui;

public class ExtensionUI  extends RentalBaseUI {
	
	String id;
	
	public ExtensionUI(String id) {
		this.id = id;
	}
	@Override
	public void execute() throws Exception {
		int b_no = scanInt("\n\t연장할 도서 번호 입력 : ");
		System.out.println();
		int cnt = service.extension(id, b_no);
		if(cnt== 1) {
			System.out.println("\t반납일이 일주일 연장 되었습니다.");
		} else {
			System.out.println("\t연장에 실패하였습니다. 연장가능 여부를 확인해 주세요.");
		};
	}
}
