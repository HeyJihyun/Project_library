package kr.ac.kopo.library.rental.ui;

import java.util.List;

import kr.ac.kopo.library.rental.vo.RentalVO;
import kr.ac.kopo.library.ui.ILibraryUI;
import kr.ac.kopo.util.Line;

public class RentalStateUI extends RentalBaseUI {

    String id;

    public RentalStateUI(String id) {
        this.id = id;
    }

    private int menu() {
        Line.line('_');
        System.out.println();
        System.out.println("\t1.반납하기 \t2.연장하기 \t3.이전페이지");
        Line.line('_');
        int select = scanInt("\n\t원하는 항목을 선택해 주세요 : ");
        return select;

    }

    public void getRState() {
        List<RentalVO> rentalList = service.getRState(id);

        Line.line('_');
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t 대여목록\n");
        Line.line('_');
        System.out.printf("\n \t%-4s\t %-6s\t \t%-10s \t%-10s \t%-50s \n", "번호", "연장여부", "대여일", "반납일", "제목");
        Line.line('.');
        System.out.println();

        if (rentalList == null || rentalList.size() == 0) {
            System.out.println("\t대여 목록이 없습니다.");
        } else {
            for (RentalVO rental : rentalList) {
                System.out.printf(" \t%03d \t", rental.getB_no());
                System.out.printf(" \t%-6s \t", rental.getExtension() == 1 ? "연장가능" : "연장불가");
                System.out.printf(" \t%-10s \t", rental.getRental_date());
                System.out.printf(" \t%-10s \t", rental.getReturn_date());
                System.out.printf(" \t%-50s \n", rental.getTitle());
            }
        }
        Line.line('_');
    }

    @Override
    public void execute() throws Exception {

        while (true) {
            getRState();
            int select = menu();
            ILibraryUI ui = null;
            switch (select) {
            case 1:
                ui = new ReturnBookUI(id);
                break;
            case 2:
                ui = new ExtensionUI(id);
                break;
            case 3:
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
