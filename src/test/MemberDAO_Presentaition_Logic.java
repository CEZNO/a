package test;


import java.util.ArrayList;
import java.util.Date;

public class MemberDAO_Presentaition_Logic {
	public static void main(String[] args) {

		MemberDAO dao = new MemberDAO();
		// MemberDAO 클래스를 사용하기 위해서 객체 생성.

		ArrayList<MemberDTO> list = dao.select();
		// MemberDAO 클래스의 select 메소드 호출.
		// 결과값으로는 mem 테이블의 모든 레코드를 저장하고 있는
		// ArrayList 객체를 리턴 받는다.

		for (MemberDTO dto : list) {
			
			String id = dto.getId();
			String pw = dto.getPw();
			String name = dto.getName();
			String adress = dto.getAdress();
			long signup_ip = dto.getSignup_ip();
			Date signup_date = dto.getSignup_date();
			System.out.println(id + "\t" + pw + "\t" + name + "\t" + adress + "\t" + signup_ip + "\t" + signup_date);
		} // for ~ each 문을 이용해서 ArrayList 에 저장된 레코드의 값을 출력한다.

	}

}
