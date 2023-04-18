package kr.ac.kopo.library.manager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.kopo.util.ConnectionFactory;

public class ManagerDAO {

	// 메니저 체크
	public boolean managerCheck(String id) {

		String sql = "select grade from t_member where id = ?";
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			pstmt.setString(1, id);

			ResultSet rs = pstmt.executeQuery();
			rs.next();
			if (rs.getString("grade").equals("관리자"))
				return true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
}
