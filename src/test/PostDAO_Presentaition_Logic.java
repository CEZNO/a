package test;


import java.util.ArrayList;
import java.util.Date;

import board.PostDTO;

public class PostDAO_Presentaition_Logic {
	public static void main(String[] args) {

		PostDAO dao = new PostDAO();
		// MemberDAO 클래스를 사용하기 위해서 객체 생성.

		ArrayList<PostDTO> list = dao.select();
		// MemberDAO 클래스의 select 메소드 호출.
		// 결과값으로는 mem 테이블의 모든 레코드를 저장하고 있는
		// ArrayList 객체를 리턴 받는다.

		for (PostDTO dto : list) {
			
			long pst_no = dto.getPst_no();
			String pst_title = dto.getPst_title();
			String pst_text = dto.getPst_text();
			Date pst_date = dto.getPst_date();
			String id = dto.getId();
			System.out.println(
					pst_no 
					+"\t" 
					+ pst_title 
					+ "\t" 
					+ pst_text 
					+ "\t" 
					+ pst_date 
					+ "\t"
					+ id);
		} // for ~ each 문을 이용해서 ArrayList 에 저장된 레코드의 값을 출력한다.

	}

}
