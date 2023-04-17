package kr.ac.kopo.library.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
		
		String sql = "select * from t_member where id = ?";
		boolean check = false;
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			check = rs.next();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return check;
	}
	
	// 회원가입 
	public void insertMember(MemberVO member) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_member(id, pwd, name, phone) ");
		sql.append(" values(?, ?, ?, ?)");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			) {
			
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getPhone());
			int cnt = pstmt.executeUpdate();
			
			if(cnt == 1) {
				System.out.println("회원가입을 완료하였습니다.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}
	
	
	// 아이디 비번 체크
	public boolean logIn(MemberVO member) {

		String sql = "select * from t_member where id = ? and pwd = ?";
		boolean check = false;
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			
			ResultSet rs = pstmt.executeQuery();
			
			check = rs.next();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return check;
	}

}
