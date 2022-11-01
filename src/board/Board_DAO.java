package board;

import java.util.*;
import java.xml.*;

import jframebd.PostDTO;

import java.sql.*;

public class Board_DAO {

	// 연결
	private Connection conn;
	// SQL문장 전송
	private PreparedStatement ps;
	// URL
	private final String URL = "jdbc:oracle:thin:@10.100.102.27:1521:XE";

	// 연결 준비
	// 1. 드라이버 등록
	public Board_DAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	// 연결
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL, "CEZNO", "zpwmsh");
		} catch (Exception ex) {
		}
	}

	// 해제
	public void disConnection() {
		try {
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		} catch (Exception ex) {
		}
	}

	// 기능
	// 1.목록(게시판) SELECT
	public ArrayList<PostDTO> boardListData() {
		ArrayList<PostDTO> list = new ArrayList<PostDTO>();
		try {
			// 연결
			getConnection();
			// SQL문장 전송
			String sql = "SELECT pst_no," + "id," + "pst_title," + "pst_text," + "pst_date," + "hit" + "FROM post "
					+ "ORDER BY no DESC"; // 단점: 속도 늦음→INDEX
			ps = conn.prepareStatement(sql);
			// SQL 실행 후 결과값 받기
			ResultSet rs = ps.executeQuery();
			// 결과값 ArrayList에 첨부
			while (rs.next()) {
				PostDTO dto = new PostDTO();
				dto.setPst_no(rs.getLong(1));
				dto.setId(rs.getString(2));
				dto.setPst_title(rs.getString(3));
				dto.setPst_text(rs.getString(4));
				dto.setPst_date(rs.getDate(5));
				dto.setHit(rs.getLong(6));
				list.add(dto);
			}
			rs.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			disConnection();
		}
		return list;

	}

	// 2.내용보기 SELECT (WHERE) ?no=1
	public PostDTO boardDetail(long pst_no) {
		PostDTO dto = new PostDTO();
		try {
			// 연결
			getConnection();
			// SQL문장 전송 ==> 조회수 증가
			String sql = "UPDATE post SET hit=hit+1 WHERE pst_no=?";
			ps = conn.prepareStatement(sql);
			ps.setLong(1, pst_no); // ?에 값을 채운다
			// 실행
			ps.executeUpdate();
			// 내용물 데이터를 가지고 온다
			sql = "SELECT " + "pst_no," + " id," + " pst_title," + " pst_text," + " pst_date," + " hit " + "FROM post "
					+ "WHERE pst_no=?";
			ps = conn.prepareStatement(sql);
			ps.setLong(1, pst_no);
			ResultSet rs = ps.executeQuery();
			rs.next();

			dto.setPst_no(rs.getLong(1));
			dto.setId(rs.getString(2));
			dto.setPst_title(rs.getString(3));
			dto.setPst_text(rs.getString(4));
			dto.setPst_date(rs.getDate(5));
			dto.setHit(rs.getLong(6));
			rs.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			disConnection();
		}
		return dto;
	}

	// 3.글쓰기 INSERT
	public void boardInsert(PostDTO dto) {
		try {
			// 연결
			getConnection();
			String sql = "INSERT INTO" + " post(" + "pst_no," + "id," + "pst_title," + "pst_text"
					+ ") VALUES((SELECT NVL(MAX(pst_no)+1,1) " + "FROM post)" + ",?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPst_title());
			ps.setString(3, dto.getPst_text());

			ps.executeUpdate(); // auto COMMIT
		} catch (Exception ex) {

		} finally {

		}
	}
	// 4.글수정 UPDATE
	// 5.글삭제 DELETE
	// 6.찾기 SELECT
}
