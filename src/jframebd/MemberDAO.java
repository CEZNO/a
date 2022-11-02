package jframebd;

import java.sql.*;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;


public class MemberDAO {

	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";

	private static final String USER = "CEZNO"; // DB ID
	private static final String PASS = "zpwmsh"; // DB 패스워드
	Member_List mList;
	/**
	 * 필요한 변수선언
	 */
	Connection con;
	Statement st;
	PreparedStatement ps;
	ResultSet rs;

	/**
	 * 로드 연결을 위한 생성자
	 */

	public MemberDAO() {

	}

	public MemberDAO(Member_List mList) {
		this.mList = mList;
		System.out.println("DAO=>" + mList);
	}

	/** DB연결 메소드 */
	public Connection getConn() {
		Connection con = null;

		try {
			Class.forName(DRIVER); // 1. 드라이버 로딩
			con = DriverManager.getConnection(URL, USER, PASS); // 2. 드라이버 연결

		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	/** 한사람의 회원 정보를 얻는 메소드 */
	public MemberDTO getMemberDTO(long no) {

		MemberDTO dto = new MemberDTO();

		Connection con = null; // 연결
		PreparedStatement ps = null; // 명령
		ResultSet rs = null; // 결과

		try {

			con = getConn();
			String sql = "select * from mem where no=?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, no);

			rs = ps.executeQuery();

			if (rs.next()) {
				dto.setNo(rs.getLong("no"));
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto;
	}

	/** 멤버리스트 출력 */
	public Vector getMemberList() {

		Vector data = new Vector(); // Jtable에 값을 쉽게 넣는 방법 1. 2차원배열 2. Vector 에 vector추가

		Connection con = null; // 연결
		PreparedStatement ps = null; // 명령
		ResultSet rs = null; // 결과

		try {

			con = getConn();
			String sql = "select * from mem order by no asc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Long no = rs.getLong("no");
				String name = rs.getString("name");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				// String pwd2 = pwd.replaceAll(pwd, "*******");
				// 비밀번호 출력시 **** 대체 하기.

				Vector row = new Vector();
				row.add(no);
				row.add(name);
				// 비밀번호 출력시 *** 설정.
				row.add(id);
				row.add(pw);

				data.add(row);
			} // while
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}// getMemberList()

	/** 멤버리스트 출력2 */
	public Vector getMemberList(DefaultTableModel t_model) {

		Vector data = new Vector(); // Jtable에 값을 쉽게 넣는 방법 1. 2차원배열 2. Vector 에 vector추가

		Connection con = null; // 연결
		PreparedStatement ps = null; // 명령
		ResultSet rs = null; // 결과

		try {

			con = getConn();
			String sql = "select * from mem order by no asc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Long no = rs.getLong("no");
				String name = rs.getString("name");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				// String pwd2 = pwd.replaceAll(pwd, "*******");
				// 비밀번호 출력시 **** 대체 하기.

				Vector row = new Vector();
				row.add(no);
				row.add(name);
				// 비밀번호 출력시 *** 설정.
				row.add(id);
				row.add(pw);

				data.add(row);
			} // while
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}// getMemberList()

	public boolean loginMemberCheck(String id, String pw) {
		boolean result = false;

		try {
			con = getConn();
			ps = con.prepareStatement("SELECT * FROM mem WHERE id=? and pw=?");
			ps.setString(1, id.trim());
			ps.setString(2, pw.trim());
			rs = ps.executeQuery(); // 실행
			if (rs.next())
				result = true; // 레코드가 존재하면 false

		} catch (SQLException e) {
			System.out.println(e + "=>  getPassByCheck fail");
		} finally {
			dbClose();
		}

		return result;
	}

	public boolean getIdByCheck(String id) {
		boolean result = true;

		try {
			con = getConn();
			ps = con.prepareStatement("SELECT * FROM mem WHERE id=?");
			ps.setString(1, id.trim());
			rs = ps.executeQuery(); // 실행
			if (rs.next())
				result = false; // 레코드가 존재하면 false

		} catch (SQLException e) {
			System.out.println(e + "=>  getIdByCheck fail");
		} finally {
			dbClose();
		}

		return result;

	}// getIdByCheck()

	/** 회원 등록 */
	public boolean insertMember(MemberDTO dto) {

		boolean ok = false;

		Connection con = null; // 연결
		PreparedStatement ps = null; // 명령

		try {

			con = getConn();
			// String sql = "insert into TB_MEMBER2(" + "num,name,id,pwd,snid) " +
			// "values(?,?,?,?,?)";
			String sql = "insert into mem(" + "no,name,id,pw) "
					+ "values(mem.NEXTVAL,?,?,?)";
//		String sql = "insert into TB_MEMBER2(" + "name,id,pwd,snid) " + "values(?,?,?,?)";

			ps = con.prepareStatement(sql);
			// ps.setString(1, dto.getNum());
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getId());
			ps.setString(3, dto.getPw());
			int r = ps.executeUpdate(); // 실행 -> 저장

			if (r > 0) {
				System.out.println("가입 성공");
				ok = true;
			} else {
				System.out.println("가입 실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok;
	}// insertMmeber

	/** 회원정보 수정 */
	public boolean updateMember(MemberDTO vMem) {
		System.out.println("dto=" + vMem.toString());
		boolean ok = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {

			con = getConn();
			String sql = "update mem set name=? where id=? and pw=?";

			ps = con.prepareStatement(sql);

//			ps.setString(1, vMem.getNum());
			ps.setString(1, vMem.getName());
			ps.setString(2, vMem.getId());
			ps.setString(3, vMem.getPw());

			int r = ps.executeUpdate(); // 실행 -> 수정
			// 1~n: 성공 , 0 : 실패

			if (r > 0)
				ok = true; // 수정이 성공되면 ok값을 true로 변경

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok;
	}

	/**
	 * 회원정보 삭제 : tip: 실무에서는 회원정보를 Delete 하지 않고 탈퇴여부만 체크한다.
	 */
	public boolean deleteMember(String id, String pw) {

		boolean ok = false;
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = getConn();
			String sql = "delete from mem where id=? and pw=?";

			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			int r = ps.executeUpdate(); // 실행 -> 삭제

			if (r > 0)
				ok = true; // 삭제됨;

		} catch (Exception e) {
			System.out.println(e + "-> 오류발생");
		}
		return ok;
	}

	/**
	 * DB닫기 기능 메소드
	 */
	public void dbClose() {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (ps != null)
				ps.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			System.out.println(e + "=> dbClose fail");
		}
	}// dbClose() ---

	/**
	 * 검색단어에 해당하는 레코드 검색하기 (like연산자를 사용하여 _, %를 사용할때는 PreparedStatemnet안된다. 반드시
	 * Statement객체를 이용함)
	 */
	public void getUserSearch2(DefaultTableModel dt, String word) {

		String sql = "SELECT * FROM mem WHERE name" + " LIKE '%" + word.trim() + "%'" + "or id LIKE '%"
				+ word.trim() + "%'";

		Connection con = null; // 연결
//        PreparedStatement ps = null; //명령
		ResultSet rs = null; // 결과
		Statement st = null;
		try {
			con = getConn();
			st = con.createStatement();
			rs = st.executeQuery(sql);

			// DefaultTableModel에 있는 기존 데이터 지우기
			for (int i = 0; i < dt.getRowCount();) {
				dt.removeRow(0);
			}

			while (rs.next()) {
				Object data[] = { rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5) };

				dt.addRow(data);
			}

		} catch (SQLException e) {
			System.out.println(e + "=> getUserSearch fail");
			e.printStackTrace();
		} finally {
			dbClose();
		}

	}// getUserSearch2()

	public void getUserSearch(DefaultTableModel dt, String fieldName, String word) {

		String sql = "SELECT * FROM mem WHERE " + fieldName.trim() + " LIKE '%" + word.trim() + "%'";

		Connection con = null; // 연결
//        PreparedStatement ps = null; //명령
		ResultSet rs = null; // 결과
		Statement st = null;
		try {
			con = getConn();
			st = con.createStatement();
			rs = st.executeQuery(sql);

			// DefaultTableModel에 있는 기존 데이터 지우기
			for (int i = 0; i < dt.getRowCount();) {
				dt.removeRow(0);
			}
			System.out.println("rs 확인전");
			while (rs.next()) {
				Object data[] = { rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5) };

				dt.addRow(data);
			}

		} catch (SQLException e) {
			System.out.println(e + "=> getUserSearch fail");
			e.printStackTrace();
		} finally {
			dbClose();
		}

	}// getUserSearch()

	/** DB데이터 다시 불러오기 */
	public void userSelectAll(DefaultTableModel dt) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = getConn();
			String sql = "select * from mem order by no asc";
			ps = con.prepareStatement(sql);
			// st = con.createStatement();
			rs = ps.executeQuery(sql);
			// DefaultTableModel에 있는 데이터 지우기
			for (int i = 0; i < dt.getRowCount();) {
				dt.removeRow(0);
			}
			while (rs.next()) {
				Object data[] = { rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5) };

				dt.addRow(data);
			}

		} catch (SQLException e) {
			System.out.println(e + "=> userSelectAll fail");
		} finally {
			dbClose();
		}
	}

}