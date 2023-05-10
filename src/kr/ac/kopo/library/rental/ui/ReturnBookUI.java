package kr.ac.kopo.library.rental.ui;

public class ReturnBookUI extends RentalBaseUI {

    String id;

    public ReturnBookUI(String id) {
        this.id = id;
    }

    @Override
    public void execute() throws Exception {

        int b_no = scanInt("\n\t반납할 도서 번호를 입력 : ");
        System.out.println();
        System.out.println("\t" + service.returnRental(id, b_no) + "권의 도서반납을 완료하였습니다.");

    }
}
