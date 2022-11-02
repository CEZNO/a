package board;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.*;
import test.PostDTO;

@WebServlet("/Board_Detail")
public class Board_Detail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 브라우저에서 실행하는 화면:HTML
		// 브라우저에 알림 : HTML문서 전송
		response.setContentType("text/html;charset=UTF-8");
		// HTML을 브라우저로 전송 시작
		PrintWriter out = response.getWriter();

		// 번호 받는다 ?no=10
		String pst_no = request.getParameter("pst_no");
		Board_DAO dao = new Board_DAO();
		PostDTO dto = dao.boardDetail(Long.parseLong(pst_no));

		out.println("<html>");
		out.println("<head>");
		out.println(
				"<Link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
		out.println("<style type=text/css>");
		out.println(".row {margin:0px auto; width:600px}"); // 가운데 출력:margin
		out.println("h2 {text-align:center}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=container>");
		out.println("<h2>내용 보기</h2>");
		out.println("<div class=row>");

		// post 보안 / get 다보여짐
		out.println("<table class=\"table\">");
		out.println("<tr>");
		out.println("<td class=\"success text-center\" width=25%>번호</td>");
		out.println("<td width=25% class=text-center>" + dto.getPst_no() + "</td>");
		out.println("<td class=\"success text-center\" width=25%>작성일</td>");
		out.println("<td width=25% class=text-center>" + dto.getPst_date() + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td class=\"success text-center\" width=25%>이름</td>");
		out.println("<td width=25% class=text-center>" + dto.getId() + "</td>");
		out.println("<td class=\"success text-center\" width=25%>조회수</td>");
		out.println("<td width=25% class=text-center>" + dto.getHit() + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td class=\"success text-center\" width=25%>제목</td>");
		out.println("<td colspan=3>" + dto.getPst_title() + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td colspan=4 height=200 valign=top>" + dto.getPst_text() + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td colspan=4 class=text-right>");
		out.println("<a href=# class=\"btn btn-xs btn-success\">수정</a>");
		out.println("<a href=# class=\"btn btn-xs btn-success\">삭제</a>");
		out.println("<a href=Board_List class=\"btn btn-xs btn-success\">목록</a>");
		out.println("</td>");
		out.println("</tr>");

		out.println("</table>");
		out.println("</div>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}
}
