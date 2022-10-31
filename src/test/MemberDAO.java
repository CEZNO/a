package test;

import java.util.ArrayList; //public class ArrayList<E> extends AbstractList<E>
import java.sql.*;

public class MemberDAO {
	String driver = "oracle.jdbc.driver.OracleDriver"; // 6행 ~ 9행 데이터베이스 접속을 위한 4가지 정보를 String 변수에 저장.
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String userid = "CEZNO";
	String passwd = "zpwmsh";

	public MemberDAO() {
		try {
			Class.forName(driver); // 드라이버를 로딩하는 초기화 작업을 생성자에서 구현한다.
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<MemberDTO> select() {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(url, userid, passwd);
			// DriverManager 클래스의 getConnection() 메소드를
			// 이용해서 Connection 객체를 얻는다.

			String query = "SELECT * FROM MEMBER";
			// 요청할 SQL 문을 String 변수에 저장한다.

			pstmt = con.prepareStatement(query);
			// SQL 문 전송에 필요한 PreparedStatement 객체를
			// Connection 객체의 preparedStatement(sql)메소드를 이용해서 얻는다.

			rs = pstmt.executeQuery();
			// SELECT 문을 요청하기 때문에 executeQuery() 메소드를 사용하며
			// 결과는 ResultSet 객체로 받는다.

			while (rs.next()) {
				MemberDTO dto = new MemberDTO();
				// 각각의 레코드 정보를 JDBC_Ex_DTO 클래스의 객체에 저장한다.

				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setAdress(rs.getString("adress"));
				dto.setSignup_ip(rs.getInt("signup_ip"));
				dto.setSignup_date(rs.getDate("signup_date"));
				list.add(dto); // 저장된 JDBC_Ex_DTO 클래스의 객체를 누적시키기 위해서
				// ArrayList 객체 저장한다. while 문이 모두 실행된 후에는 dept 테이블의 모든 레코드가
				// ArrayList 의 객체에 모두 저장된다.
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
