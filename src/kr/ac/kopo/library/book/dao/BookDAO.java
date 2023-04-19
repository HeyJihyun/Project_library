package kr.ac.kopo.library.book.dao;

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
		sql.append("SELECT B_NO,");
		sql.append("       TITLE,");
		sql.append("       WRITER,");
		sql.append("       REG_DATE,");
		sql.append("       PUB_DATE,");
		sql.append("       PUBLISHER,");
		sql.append("       GENRE,");
		sql.append("       CASE when b_no in (select b_no from t_rental) then '대여불가' else '대여가능' end as 대여현황");
		sql.append(" from t_book where ");
		sql.append(search);
		sql.append(" like ? ");
		sql.append(" order by 대여현황");
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
				String r_state = rs.getString(8);
				bookList.add(new BookVO(b_no, title, writer, reg_date, pub_date, publisher, genre, r_state));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return bookList;
	}

	public List<BookVO> selectAll() {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT B_NO,");
		sql.append("       TITLE,");
		sql.append("       WRITER,");
		sql.append("       REG_DATE,");
		sql.append("       PUB_DATE,");
		sql.append("       PUBLISHER,");
		sql.append("       GENRE,");
		sql.append("       CASE when b_no in (select b_no from t_rental) then '대여불가' else '대여가능' end as 대여현황");
		sql.append(" from t_book ");
		sql.append(" order by 대여현황, b_no");
		List<BookVO> bookList = new ArrayList<>();

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int b_no = rs.getInt(1);
				String title = rs.getString(2);
				String writer = rs.getString(3);
				String reg_date = rs.getString(4);
				String pub_date = rs.getString(5);
				String publisher = rs.getString(6);
				String genre = rs.getString(7);
				String r_state = rs.getString(8);
				bookList.add(new BookVO(b_no, title, writer, reg_date, pub_date, publisher, genre, r_state));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return bookList;
	}

	// 도서등록
	public int insertBook(BookVO book) {

		int cnt = 0;

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO T_BOOK (");
		sql.append("       B_NO,");
		sql.append("       TITLE,");
		sql.append("       WRITER,");
		sql.append("       PUB_DATE,");
		sql.append("       PUBLISHER,");
		sql.append("       GENRE");
		sql.append(") VALUES ( SEQ_T_BOOK_NO.NEXTVAL, ?, ?, ?, ?, ?)");
		List<BookVO> bookList = new ArrayList<>();

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getWriter());
			pstmt.setString(3, book.getPub_date());
			pstmt.setString(4, book.getPublisher());
			pstmt.setString(5, book.getGenre());

			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return cnt;
	}

	// 도서정보 수정
	public int updateBook(int b_no, String type, String change) {
		StringBuilder sql = new StringBuilder();
		sql.append("update t_book");
		sql.append(" set " + type + " = ?");
		sql.append("where b_no = ?");

		int cnt = 0;

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			pstmt.setString(1, change);
			pstmt.setInt(2, b_no);

			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return cnt;

	}

	// 도서삭제
	public int deleteBook(int b_no) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from t_book ");
		sql.append("where b_no = ?");

		int cnt = 0;

		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			) {

			pstmt.setInt(1, b_no);

			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return cnt;

	}

}
