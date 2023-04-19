package kr.ac.kopo.library.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.library.member.vo.MemberVO;
import kr.ac.kopo.util.ConnectionFactory;

/**
 * 
 * 오라클 DB t_member 테이블에 게시글 CRUD하는 DAO클래스
 * 
 * @author User
 *
 */
public class MemberDAO {
	
	// 아이디 중복 체크
	public boolean checkId(String id) {
		boolean check = (getMember(id).getId() != null);
		return check;
	}
	
	// 회원가입 
	public int insertMember(MemberVO member) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_member(id, pwd, name, phone) ");
		sql.append(" values(?, ?, ?, ?)");
		int cnt = 0;
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			) {
			
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getPhone());
			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return cnt;
	
	}
	
	
	// 아이디 비번 체크
	public boolean logIn(String id, String pwd) {

		String sql = "select * from t_member where id = ? and pwd = ?";
		boolean check = false;
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			
			ResultSet rs = pstmt.executeQuery();
			
			check = rs.next();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return check;
	}
	
	// 회원정보 수정
	public int updateMember(String id, String type, String change) {
		StringBuilder sql = new StringBuilder();
		sql.append("update t_member");
		sql.append(" set " + type + " = ?");
		sql.append("where id = ?");
		
		int cnt = 0;
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			
			pstmt.setString(1, change);
			pstmt.setString(2, id);
			
			cnt = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cnt;
		
	}
	
	
	// 회원 정보 조회 (1명)
	public MemberVO getMember(String id) {
		MemberVO member = new MemberVO();
		
		String sql = "select * from t_member where id = ?";
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member.setId(id);
				member.setName(rs.getString("name"));
				member.setPhone(rs.getString("phone"));
			};
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return member;
	}
	
	// 전체 회원 조회
	public List<MemberVO> selectAll(){
		List<MemberVO> memberList = new ArrayList<>();
		String sql = "select * from t_member";

		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			) {

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				MemberVO member = new MemberVO();
				member.setId(rs.getString("id"));
				member.setName(rs.getString("name"));
				member.setPhone(rs.getString("phone"));
				member.setGrade(rs.getString("grade"));
				memberList.add(member);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return memberList;
	}
	
	
	
	// 회원 탈퇴
	public int delete(String id) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from t_member ");
		sql.append("where id = ?");
		
		int cnt = 0;
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			
			pstmt.setString(1, id);
			
			cnt = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("\t대여중인 도서가 있을 경우 탈퇴가 불가합니다.");
		}
		
		return cnt;
		
	}

}
