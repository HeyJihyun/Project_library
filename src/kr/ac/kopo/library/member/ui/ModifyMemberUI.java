package kr.ac.kopo.library.member.ui;

import kr.ac.kopo.library.member.vo.MemberVO;
import kr.ac.kopo.util.Line;

public class ModifyMemberUI extends MemeberBaseUI {

    String id;

    public ModifyMemberUI(String id) {
        this.id = id;
    }

    private int menu() {
        Line.line('_');
        System.out.println();
        System.out.println("\t1.비밀번호 수정 \t2.이름변경 \t3.핸드폰 번호 수정 \t4.이전페이지");
        Line.line('_');
        int select = scanInt("\n\t원하는 항목을 선택해 주세요 : ");
        return select;
    }

    // 회원정보 조회
    private void viewInfo() {
        System.out.println();
        Line.line('_');
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t  회원정보");
        Line.line('.');
        System.out.println();
        MemberVO member = service.getMember(id);
        System.out.println("\t아이디 \t\t: \t" + member.getId());
        System.out.println("\t이름 \t\t: \t" + member.getName());
        System.out.println("\t핸드폰번호\t: \t" + member.getPhone());
        Line.line('_');
        ;
    }

    @Override
    public void execute() throws Exception {

        String pwd = scanString("\t비밀번호를 입력\t : ");
        if (service.logIn(id, pwd)) {
            String type = null;

            while (true) {
                viewInfo();
                switch (menu()) {
                case 1:
                    type = "pwd";
                    break;
                case 2:
                    type = "name";
                    break;
                case 3:
                    type = "phone";
                    break;
                case 4:
                    return;
                }

                System.out.println();
                if (type != null) {
                    String change = scanString("\t수정 내용 : ");
                    int result = service.updateMember(id, type, change);
                    System.out.println();
                    if (result == 1) {
                        System.out.println("\t수정이 완료되었습니다.");
                    } else {
                        System.out.println("\t수정에 실패하였습니다.");
                    }
                } else {
                    System.out.println("\t잘못입력 하셨습니다.");
                }
            }

        } else {
            System.out.println("\t잘못입력 하셨습니다.");
            execute();
        }
        ;

    }

}
