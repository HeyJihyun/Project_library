package kr.ac.kopo.library.member.service;

import kr.ac.kopo.library.member.dao.MemberDAO;
import kr.ac.kopo.library.member.vo.MemberVO;

public class MemberService {
	
	private MemberDAO memberDao;
	
	public MemberService() {
		memberDao = new MemberDAO();
	}

	// 아이디 중복확인
	public boolean checkId(String id) {
		return memberDao.checkId(id);
	}
	
	// 회원가입
	public void insertMember(MemberVO member) {
		memberDao.insertMember(member);
	}
	
	// 아이디, 비번 확인
	public boolean logIn(MemberVO member) {
		return memberDao.logIn(member);
	}

}
