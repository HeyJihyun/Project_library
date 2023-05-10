package kr.ac.kopo.library.member.ui;

import kr.ac.kopo.library.rental.ui.RentalStateUI;
import kr.ac.kopo.library.ui.ILibraryUI;
import kr.ac.kopo.library.ui.MenuUI;

public class MypageMenuUI extends MenuUI {

    String id;

    public MypageMenuUI(String id) {
        this.id = id;
    }

    @Override
    public void execute() throws Exception {
        while (true) {
            int select = menu("\t1.대여현황 \t2.회원정보수정 \t\t3.회원탈퇴 \t4.이전페이지");
            ILibraryUI ui = null;

            switch (select) {
            case 1:
                ui = new RentalStateUI(id);
                break;
            case 2:
                ui = new ModifyMemberUI(id);
                break;
            case 3:
                ui = new DeactivateUI(id);
                break;
            case 4:
                return;
            }

            if (ui != null) {
                ui.execute();
            } else {
                System.out.println("\t - 잘못입력 하셨습니다.");
            }

        }
    }

}
