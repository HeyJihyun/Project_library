package kr.ac.kopo.library.ui;

import kr.ac.kopo.library.book.ui.SearchMenuUI;
import kr.ac.kopo.library.book.ui.ViewAllUI;
import kr.ac.kopo.library.member.ui.MypageMenuUI;
import kr.ac.kopo.library.rental.ui.SelectRental;

public class SubMemu extends MenuUI {

    String id;

    public SubMemu(String id) {
        this.id = id;
    }

    @Override
    public void execute() throws Exception {

        while (true) {

            int select = menu("\t1.도서검색 \t2.전체도서 조회 \t3.대여도서 선택 \t4.마이페이지 \t\t5.로그아웃 \t6.프로그램 종료");
            ILibraryUI ui = null;

            switch (select) {
            case 1:
                ui = new SearchMenuUI();
                break;
            case 2:
                ui = new ViewAllUI();
                break;
            case 3:
                ui = new SelectRental(id);
                break;
            case 4:
                ui = new MypageMenuUI(id);
                break;
            case 5:
                return;
            case 6:
                ui = new ExitUI();
                break;
            }

            if (ui != null) {
                ui.execute();
            } else {
                System.out.println("\n\t - 잘못입력 하셨습니다.");
            }
        }

    }

}
