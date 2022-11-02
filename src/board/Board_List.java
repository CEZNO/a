package board;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;//ArrayList

import board.*;
import test.PostDTO;

@WebServlet("/Board_List")
public class Board_List extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 브라우저에서 실행하는 화면:HTML
		// 브라우저에 알림 : HTML문서 전송
		response.setContentType("text/html;charset=UTF-8");
		// HTML을 브라우저로 전송 시작
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println(
				"<Link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
		out.println("<style type=text/css>");
		out.println(".row {margin:0px auto; width:700px}"); // 가운데 출력:margin
		out.println("h2 {text-align:center}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=container>");
		out.println("<h2>자유게시판</h2>");
		out.println("<div class=row>");

		out.println("<table class=\"table\">");
		out.println("<tr>");
		out.println("<td>");
		out.println("<a href=Board_Insert class=\"btn btn-sm btn-success\">새글</a>");
		// btn-sm 크기 / btn-lg : 버튼 커짐 / btn-xs : 버튼 작아짐
		// success - 녹색
		out.println("</td>");
		out.println("</tr>");
		out.println("<table>");

		out.println("<table class=\"table table-hover\">");
		out.println("<tr class=info>"); // 색상 빨간색:danger(table-hover)
		out.println("<th class=text-center width=10%>번호</th>");
		out.println("<th class=text-center width=45%>제목</th>");
		out.println("<th class=text-center width=15%>이름</th>");
		out.println("<th class=text-center width=20%>작성일</th>");
		out.println("<th class=text-center width=10%>조회수</th>");
		out.println("</tr>");
		// 출력
		Board_DAO dao = new Board_DAO();
		ArrayList<PostDTO> list = dao.boardListData();
		for (PostDTO dto : list) {
			out.println("<tr>");
			out.println("<th class=text-center width=10%>" + dto.getPst_no() + "</th>");
			out.println("<th class=text-left width=45%>" + "<a href=Board_Detail?no=" + dto.getPst_no() + ">"
					+ dto.getPst_title() + "</a></td>");
			out.println("<th class=text-center width=15%>" + dto.getId() + "</th>");
			out.println("<th class=text-center width=20%>" + dto.getPst_date().toString() + "</th>");
			out.println("<th class=text-center width=10%>" + dto.getHit() + "</th>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("<hr>");

		out.println("<table class=\"table\">");
		out.println("<tr>");

		out.println("<td class=text-left>");
		out.println("Search:");
		out.println("<select class=input-sm>");
		out.println("<option>이름<option>");
		out.println("<option>제목<option>");
		out.println("<option>내용<option>");
		out.println("</select>");
		out.println("<input type=text size 15 class=input-sm>");
		out.println("<input type=button value=찾기 class=\"btn btn-sm btn-danger\">");
		out.println("</td>");

		out.println("<td class=text-right>");
		// primary -진한 청색
		out.println("<a href=Board_Insert class=\"btn btn-sm btn-primary\">이전</a>");
		out.println("0 page / 0 pages");
		out.println("<a href=Board_Insert class=\"btn btn-sm btn-primary\">다음</a>");
		out.println("</td>");

		out.println("</tr>");
		out.println("<table>");

		out.println("</div>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}
}
