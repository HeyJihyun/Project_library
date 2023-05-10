package kr.ac.kopo.library.member.ui;

import kr.ac.kopo.library.member.vo.MemberVO;

public class MemberCreateUI extends MemeberBaseUI {

    @Override
    public void execute() throws Exception {

        System.out.println("\t_");
        System.out.println("\n\t회원가입을 선택하셨습니다.\n");
        System.out.println();
        String id = scanString("\tid 입력\t\t : ");

        while (service.checkId(id)) {
            System.out.println("\t - 중복된 아이디 입니다.");
            System.out.println();
            id = scanString("\tid 입력\t\t : ");
        }
        ;

        String pwd = scanString("\t비밀번호 입력\t : ");
        while (!pwd.equals(scanString("\t비밀번호 확인\t : "))) {
            System.out.println("\t - 비밀번호를 확인해 주세요.\n");
            pwd = scanString("\t비밀번호 입력\t : ");
        }

        String name = scanString("\t이름 입력 \t : ");
        String phone = scanString("\t연락처 입력 \t : ");

        MemberVO member = new MemberVO(id, pwd, name, phone);

        if (service.insertMember(member) == 1) {
            System.out.println("\t_");
            System.out.println("\n\t회원가입을 완료하였습니다.");
        }

    }

}
