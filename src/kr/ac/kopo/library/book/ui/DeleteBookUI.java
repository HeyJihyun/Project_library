package kr.ac.kopo.library.book.ui;

public class DeleteBookUI extends BookBaseUI {

    @Override
    public void execute() throws Exception {

        System.out.println("\t_\n");
        System.out.println("\t도서삭제");
        System.out.println("\t_\n");

        int b_no = scanInt("\t삭제할 책 번호 \t: ");
        switch (scanString("\t정말 삭제하시려면 1번을 눌러주세요.(그 외 이전페이지)").charAt(0)) {
        case '1':
            int result = service.deleteBook(b_no);
            if (result > 0) {
                System.out.println("\t" + result + "권의 책을 삭제하였습니다.\n");
            } else {
                System.out.println("\n\t대여중인 도서는 삭제가 불가능 합니다.");
            }
            System.out.println();
            break;
        default:
            return;
        }

    }
}
