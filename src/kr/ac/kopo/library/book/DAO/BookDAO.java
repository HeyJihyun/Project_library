package kr.ac.kopo.library.book.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.library.book.vo.BookVO;
import kr.ac.kopo.util.ConnectionFactory;

public class BookDAO {

	public List<BookVO> searchSelect(String search, String detail) {

		StringBuilder sql = new StringBuilder();
		sql.append("select * from t_book where ");
		sql.append(search);
		sql.append(" like ?");
		List<BookVO> bookList = new ArrayList<>();

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			pstmt.setString(1, "%" + detail + "%");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int b_no = rs.getInt(1);
				String title = rs.getString(2);
				String writer = rs.getString(3);
				String reg_date = rs.getString(4);
				String pub_date = rs.getString(5);
				String publisher = rs.getString(6);
				String genre = rs.getString(7);
				bookList.add(new BookVO(b_no, title, writer, reg_date, pub_date, publisher, genre));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return bookList;
	}

	public List<BookVO> selectAll() {

		StringBuilder sql = new StringBuilder();
		sql.append("select * from t_book order by b_no desc ");
		List<BookVO> bookList = new ArrayList<>();

		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			){

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int b_no = rs.getInt(1);
				String title = rs.getString(2);
				String writer = rs.getString(3);
				String reg_date = rs.getString(4);
				String pub_date = rs.getString(5);
				String publisher = rs.getString(6);
				String genre = rs.getString(7);
				bookList.add(new BookVO(b_no, title, writer, reg_date, pub_date, publisher, genre));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return bookList;
	}

}
