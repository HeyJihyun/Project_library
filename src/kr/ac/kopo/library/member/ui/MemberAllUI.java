package kr.ac.kopo.library.member.ui;

import java.util.List;

import kr.ac.kopo.library.member.vo.MemberVO;
import kr.ac.kopo.util.Line;

public class MemberAllUI extends MemeberBaseUI {

    @Override
    public void execute() throws Exception {
        List<MemberVO> memberList = service.selectAll();

        System.out.println();
        Line.line('_');
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t  전체 회원 조회\n");
        Line.line('_');
        System.out.printf("\n \t\t%-30s\t %-20s\t \t%-13s\t %-3s\n", "아이디", "이름", "연락처", "등급");
        Line.line('.');
        System.out.println();

        if (memberList == null || memberList.size() == 0) {
            System.out.println("회원 목록이 없습니다.");
        } else {
            for (MemberVO member : memberList) {
                System.out.printf("\t%-30s \t", member.getId());
                System.out.printf("\t%-20s \t", member.getName());
                System.out.printf("\t%-13s \t", member.getPhone());
                System.out.printf("\t%-3s \n", member.getGrade());
            }
        }

    }
}
