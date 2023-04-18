package kr.ac.kopo.library.member.service;

import java.util.List;

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
	public boolean logIn(String id, String pwd) {
		return memberDao.logIn(id, pwd);
	}
	
	// 회원정보 수정
	public int updateMember(String id, String type, String change) {
		return memberDao.updateMember(id, type, change);
	}
	
	// 회원정보 조회 (1명)
	public MemberVO getMember(String id) {
		return memberDao.getMember(id);
	}
	
	// 회원 탈퇴
	public int delete(String id) {
		return memberDao.delete(id);
	}
	
	public List<MemberVO> selectAll(){
		return memberDao.selectAll();
	}
	

}
