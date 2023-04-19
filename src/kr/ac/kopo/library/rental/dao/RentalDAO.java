package kr.ac.kopo.library.rental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.library.rental.vo.RentalVO;
import kr.ac.kopo.util.ConnectionFactory;

public class RentalDAO {
	
	// 대여현황 조회
	public List<RentalVO> getRState(String id){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT B.B_NO,");
		sql.append("       B.TITLE,");
		sql.append("       to_char(RENTAL_DATE, 'yyyy-mm-dd'),");
		sql.append("       to_char(RETURN_DATE, 'yyyy-mm-dd'),");
		sql.append("       EXTENSION");
		sql.append("  FROM T_RENTAL A");
		sql.append("  JOIN T_BOOK B ON A.B_NO = B.B_NO");
		sql.append(" WHERE U_ID = ?");
		sql.append(" order by return_date");
		List<RentalVO> rentalList = new ArrayList<>();

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			pstmt.setString(1, id);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int b_no = rs.getInt(1);
				String title = rs.getString(2);
				String rental_date = rs.getString(3);
				String return_date = rs.getString(4);
				int extension = rs.getInt(5);
				rentalList.add(new RentalVO(b_no, id, title, rental_date, return_date, extension));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return rentalList;
	
	}
	
	
	// 대여하기
	public int insertRental(RentalVO vo) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_rental(r_no, b_no, u_id) ");
		sql.append(" values(seq_t_rental.nextval, ?, ?)");
		
		int cnt = 0;
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			) {
			
			pstmt.setInt(1, vo.getB_no());
			pstmt.setString(2, vo.getU_id());
			cnt = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("도서대여에 실패하였습니다. 대여 현황을 확인해 주세요.");
		}
	
		return cnt;
	}
	
	// 반납하기
	public int returnRental(String id, int b_no) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from t_rental ");
		sql.append(" where u_id = ? and b_no = ?");
		int cnt = 0;
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			) {
			
			pstmt.setString(1, id);
			pstmt.setInt(2, b_no);
			cnt = pstmt.executeUpdate();
			

		} catch (Exception e) {
			e.printStackTrace();;
		}
		
		return cnt;
	}
	
	// 대여 연장
	public int extension(String id, int b_no) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE T_RENTAL ");
		sql.append("   SET RETURN_DATE = RETURN_DATE + 7,");
		sql.append("       EXTENSION = '0' ");
		sql.append(" WHERE U_ID = ? ");
		sql.append("   AND B_NO      = ? ");
		sql.append("   AND EXTENSION = '1' ");
		int cnt = 0;
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			) {
			
			pstmt.setString(1, id);
			pstmt.setInt(2, b_no);
			cnt = pstmt.executeUpdate();
			

		} catch (Exception e) {
			e.printStackTrace();;
		}
		
		return cnt;
	}

}
